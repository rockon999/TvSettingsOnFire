/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rockon999.android.tv.settings.accessories;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rockon999.android.tv.settings.R;
import com.rockon999.android.tv.settings.util.AccessibilityHelper;

/**
 * Custom Content Fragment for the Bluetooth settings activity.
 */
public class AddAccessoryContentFragment extends Fragment {

    private static final String MULTIPLE = "multiple";

    public View mView;
    private boolean mMultiple;

    public static AddAccessoryContentFragment newInstance(boolean multiple) {
        AddAccessoryContentFragment fragment = new AddAccessoryContentFragment();
        Bundle args = new Bundle();
        args.putBoolean(MULTIPLE, multiple);
        fragment.setArguments(args);
        return fragment;
    }

    public AddAccessoryContentFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMultiple = getArguments().getBoolean(MULTIPLE);

        mView = inflater.inflate(mMultiple ? R.layout.add_accessory_multiple_content_fragment :
                R.layout.add_accessory_content_fragment, container, false);

        // Enable focusability of text views if accessibility is enabled.
        if (AccessibilityHelper.forceFocusableViews(getActivity())) {
            TextView title = (TextView) mView.findViewById(
                    mMultiple ? R.id.multiple_title : R.id.title);
            if (title != null) {
                title.setFocusable(true);
                title.setFocusableInTouchMode(true);
            }
            TextView instructions = (TextView) mView.findViewById(
                    mMultiple ? R.id.multiple_instructions : R.id.bluetooth_instructions);
            if (instructions != null) {
                instructions.setFocusable(true);
                instructions.setFocusableInTouchMode(true);
            }
            TextView autopair = (TextView) mView.findViewById(
                    mMultiple ? R.id.select_instructions : R.id.autopair_message);
            if (autopair != null) {
                autopair.setFocusable(true);
                autopair.setFocusableInTouchMode(true);
            }
        }
        return mView;
    }
}
