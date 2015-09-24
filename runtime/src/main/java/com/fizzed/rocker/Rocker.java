/*
 * Copyright 2015 Fizzed Inc.
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
package com.fizzed.rocker;

import com.fizzed.rocker.runtime.RockerRuntime;

/**
 *
 * @author joelauer
 */
public class Rocker {
    
    // intended for dynamic usage of templates (interfaces & template)
    /**
     * Creates a template at runtime with properties that can be set (bindable)
     * dynamically at runtime via Java reflection.
     * 
     * @param templatePath The path to the template such as "views/app/index.rocker.html".
     *      The value is converted to a Java package name such as "views.app.index"
     *      which is then loaded from the classpath.  If hot reloading is turned on
     *      then the template is checked if it needs (re)compiled as well.
     * @return A template model with bindable properties.
     */
    static public BindableRockerModel template(String templatePath) {
        
        // load model from bootstrap (which may recompile if needed)
        RockerModel model = RockerRuntime.getInstance().getBootstrap().model(templatePath);
        
        return new BindableRockerModel(templatePath, model.getClass().getCanonicalName(), model);
        
    }
    
}
