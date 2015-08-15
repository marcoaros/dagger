/*
 * Copyright (C) 2015 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.subcomponent;

import dagger.Module;
import dagger.Provides;
import test.TestStringKey;

import static dagger.Provides.Type.MAP;
import static dagger.Provides.Type.SET;

@Module
class ParentMultibindingModule {

  @Provides(type = SET)
  Object provideObject() {
    return "object provided by parent";
  }

  @Provides(type = SET)
  String provideString() {
    return "string provided by parent";
  }

  @Provides(type = SET)
  RequiresMultiboundObjects requiresMultiboundObjects(
      RequiresMultiboundObjects requiresMultiboundObjects) {
    return requiresMultiboundObjects;
  }

  @Provides(type = MAP)
  @TestStringKey("parent key")
  String parentKeyString() {
    return "string in parent";
  }

  @Provides(type = MAP)
  @TestStringKey("parent key")
  Object parentKeyObject() {
    return "object in parent";
  }
}