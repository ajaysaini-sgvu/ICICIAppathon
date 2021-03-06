/*
 *
 *  Copyright 2017 Nagarro Agile. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package com.icici.iciciappathon;

import android.app.Application;

import com.icici.iciciappathon.dagger.component.DaggerNetComponent;
import com.icici.iciciappathon.dagger.component.NetComponent;
import com.icici.iciciappathon.dagger.module.AppModule;


/**
 * {@link android.app.Application} used to initialize global application state.
 */
public class AppApplication extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public NetComponent getmNetComponent() {
        return mNetComponent;
    }

}
