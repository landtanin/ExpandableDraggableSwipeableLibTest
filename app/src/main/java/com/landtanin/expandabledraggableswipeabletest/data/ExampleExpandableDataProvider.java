/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.landtanin.expandabledraggableswipeabletest.data;


import android.support.v4.util.Pair;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExampleExpandableDataProvider extends AbstractExpandableDataProvider {
    private List<Pair<GroupData, List<ChildData>>> mData;

    // for undo group item
    private Pair<GroupData, List<ChildData>> mLastRemovedGroup;
    private int mLastRemovedGroupPosition = -1;

    // for undo child item
    private ChildData mLastRemovedChild;
    private long mLastRemovedChildParentGroupId = -1;
    private int mLastRemovedChildPosition = -1;

    public ExampleExpandableDataProvider() {

        mData = new LinkedList<>();

        for (int groupIndex = 0; groupIndex < 15; groupIndex++) {

            final ConcreteGroupData group = new ConcreteGroupData(
                                                    groupIndex,
                                                    "group " + groupIndex);
            final List<ChildData> children = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                children.add(new ConcreteChildData(i, "child " + i));
            }

            mData.add(new Pair<GroupData, List<ChildData>>(group, children));

        }

    }

    @Override
    public int getGroupCount() {
        return mData.size();
    }

    @Override
    public int getChildCount(int groupPosition) {
        return mData.get(groupPosition).second.size();
    }

    @Override
    public GroupData getGroupItem(int groupPosition) {
        if (groupPosition < 0 || groupPosition >= getGroupCount()) {
            throw new IndexOutOfBoundsException("groupPosition = " + groupPosition);
        }

        return mData.get(groupPosition).first;
    }

    @Override
    public ChildData getChildItem(int groupPosition, int childPosition) {
        if (groupPosition < 0 || groupPosition >= getGroupCount()) {
            throw new IndexOutOfBoundsException("groupPosition = " + groupPosition);
        }

        final List<ChildData> children = mData.get(groupPosition).second;

        if (childPosition < 0 || childPosition >= children.size()) {
            throw new IndexOutOfBoundsException("childPosition = " + childPosition);
        }

        return children.get(childPosition);
    }

    @Override
    public void moveGroupItem(int fromGroupPosition, int toGroupPosition) {
        if (fromGroupPosition == toGroupPosition) {
            return;
        }

        final Pair<GroupData, List<ChildData>> item = mData.remove(fromGroupPosition);
        mData.add(toGroupPosition, item);
    }

    @Override
    public void moveChildItem(int fromGroupPosition, int fromChildPosition, int toGroupPosition, int toChildPosition) {
        if ((fromGroupPosition == toGroupPosition) && (fromChildPosition == toChildPosition)) {
            return;
        }

        final Pair<GroupData, List<ChildData>> fromGroup = mData.get(fromGroupPosition);
        final Pair<GroupData, List<ChildData>> toGroup = mData.get(toGroupPosition);

        final ConcreteChildData item = (ConcreteChildData) fromGroup.second.remove(fromChildPosition);

        if (toGroupPosition != fromGroupPosition) {
            // assign a new ID
            final long newId = ((ConcreteGroupData) toGroup.first).generateNewChildId();
            item.setChildId(newId);
        }

        toGroup.second.add(toChildPosition, item);
    }

    @Override
    public void removeGroupItem(int groupPosition) {
        mLastRemovedGroup = mData.remove(groupPosition);
        mLastRemovedGroupPosition = groupPosition;

        mLastRemovedChild = null;
        mLastRemovedChildParentGroupId = -1;
        mLastRemovedChildPosition = -1;
    }

    @Override
    public void removeChildItem(int groupPosition, int childPosition) {
        mLastRemovedChild = mData.get(groupPosition).second.remove(childPosition);
        mLastRemovedChildParentGroupId = mData.get(groupPosition).first.getGroupId();
        mLastRemovedChildPosition = childPosition;

        mLastRemovedGroup = null;
        mLastRemovedGroupPosition = -1;
    }


    @Override
    public long undoLastRemoval() {
        if (mLastRemovedGroup != null) {
            return undoGroupRemoval();
        } else if (mLastRemovedChild != null) {
            return undoChildRemoval();
        } else {
            return RecyclerViewExpandableItemManager.NO_EXPANDABLE_POSITION;
        }
    }

    private long undoGroupRemoval() {
        int insertedPosition;
        if (mLastRemovedGroupPosition >= 0 && mLastRemovedGroupPosition < mData.size()) {
            insertedPosition = mLastRemovedGroupPosition;
        } else {
            insertedPosition = mData.size();
        }

        mData.add(insertedPosition, mLastRemovedGroup);

        mLastRemovedGroup = null;
        mLastRemovedGroupPosition = -1;

        return RecyclerViewExpandableItemManager.getPackedPositionForGroup(insertedPosition);
    }

    private long undoChildRemoval() {
        Pair<GroupData, List<ChildData>> group = null;
        int groupPosition = -1;

        // find the group
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).first.getGroupId() == mLastRemovedChildParentGroupId) {
                group = mData.get(i);
                groupPosition = i;
                break;
            }
        }

        if (group == null) {
            return RecyclerViewExpandableItemManager.NO_EXPANDABLE_POSITION;
        }

        int insertedPosition;
        if (mLastRemovedChildPosition >= 0 && mLastRemovedChildPosition < group.second.size()) {
            insertedPosition = mLastRemovedChildPosition;
        } else {
            insertedPosition = group.second.size();
        }

        group.second.add(insertedPosition, mLastRemovedChild);

        mLastRemovedChildParentGroupId = -1;
        mLastRemovedChildPosition = -1;
        mLastRemovedChild = null;

        return RecyclerViewExpandableItemManager.getPackedPositionForChild(groupPosition, insertedPosition);
    }

    public static final class ConcreteGroupData extends GroupData {

        private final long mId;
        private final String titleStr;

        private boolean mPinned;
        private long mNextChildId;

        private String detailStr;
        private String noOfOpenAlarmStr;
        private int noOfOpenAlarmInt;
        private String noOfTotalAlarmStr;
        private int noOfTotalAlarmInt;
        private String lastAlarmLabelStr;
        private String lastAlarmTimeStr;
        private int cardStatusColor;

        ConcreteGroupData(long id, String title) {
            mId = id;
            titleStr = title;
            mNextChildId = 0;
        }

        @Override
        public long getGroupId() {
            return mId;
        }

        @Override
        public boolean isSectionHeader() {
            return false;
        }

        @Override
        public String getTitle() {
            return titleStr;
        }

        @Override
        public void setPinned(boolean pinnedToSwipeLeft) {
            mPinned = pinnedToSwipeLeft;
        }

        @Override
        public boolean isPinned() {
            return mPinned;
        }

        public String getDetailStr() {
            return detailStr;
        }

        public void setDetailStr(String detailStr) {
            this.detailStr = detailStr;
        }

        public String getNoOfOpenAlarmStr() {
            return noOfOpenAlarmStr;
        }

        public void setNoOfOpenAlarmStr(String noOfOpenAlarmStr) {
            this.noOfOpenAlarmStr = noOfOpenAlarmStr;
        }

        public int getNoOfOpenAlarmInt() {
            return noOfOpenAlarmInt;
        }

        public void setNoOfOpenAlarmInt(int noOfOpenAlarmInt) {
            this.noOfOpenAlarmInt = noOfOpenAlarmInt;
        }

        public String getNoOfTotalAlarmStr() {
            return noOfTotalAlarmStr;
        }

        public void setNoOfTotalAlarmStr(String noOfTotalAlarmStr) {
            this.noOfTotalAlarmStr = noOfTotalAlarmStr;
        }

        public int getNoOfTotalAlarmInt() {
            return noOfTotalAlarmInt;
        }

        public void setNoOfTotalAlarmInt(int noOfTotalAlarmInt) {
            this.noOfTotalAlarmInt = noOfTotalAlarmInt;
        }

        public String getLastAlarmLabelStr() {
            return lastAlarmLabelStr;
        }

        public void setLastAlarmLabelStr(String lastAlarmLabelStr) {
            this.lastAlarmLabelStr = lastAlarmLabelStr;
        }

        public String getLastAlarmTimeStr() {
            return lastAlarmTimeStr;
        }

        public void setLastAlarmTimeStr(String lastAlarmTimeStr) {
            this.lastAlarmTimeStr = lastAlarmTimeStr;
        }

        public int getCardStatusColor() {
            return cardStatusColor;
        }

        public void setCardStatusColor(int cardStatusColor) {
            this.cardStatusColor = cardStatusColor;
        }

        public long generateNewChildId() {
            final long id = mNextChildId;
            mNextChildId += 1;
            return id;
        }
    }

    public static final class ConcreteChildData extends ChildData {

        private long id;
        private final String title;
        private boolean mPinned;

        private String sourceOfAlarmStr;
        private String timeStr;
        private String aboveTimeStr;
        private int circleStatusColor;

        ConcreteChildData(long id, String text) {
            this.id = id;
            title = text;
        }

        @Override
        public long getChildId() {
            return id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public void setPinned(boolean pinned) {
            mPinned = pinned;
        }

        @Override
        public boolean isPinned() {
            return mPinned;
        }

        public void setChildId(long id) {
            this.id = id;
        }

        public String getSourceOfAlarmStr() {
            return sourceOfAlarmStr;
        }

        public void setSourceOfAlarmStr(String sourceOfAlarmStr) {
            this.sourceOfAlarmStr = sourceOfAlarmStr;
        }

        public String getTimeStr() {
            return timeStr;
        }

        public void setTimeStr(String timeStr) {
            this.timeStr = timeStr;
        }

        public String getAboveTimeStr() {
            return aboveTimeStr;
        }

        public void setAboveTimeStr(String aboveTimeStr) {
            this.aboveTimeStr = aboveTimeStr;
        }

        public int getCircleStatusColor() {
            return circleStatusColor;
        }

        public void setCircleStatusColor(int circleStatusColor) {
            this.circleStatusColor = circleStatusColor;
        }
    }
}
