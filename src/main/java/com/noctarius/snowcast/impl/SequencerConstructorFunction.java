/*
 * Copyright (c) 2014, Christoph Engelbert (aka noctarius) and
 * contributors. All rights reserved.
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
package com.noctarius.snowcast.impl;

import com.hazelcast.util.ConstructorFunction;

final class SequencerConstructorFunction
        implements ConstructorFunction<SequencerDefinition, SequencerProvision> {

    private final NodeSequencerService sequencerService;

    SequencerConstructorFunction(NodeSequencerService sequencerService) {
        this.sequencerService = sequencerService;
    }

    @Override
    public SequencerProvision createNew(SequencerDefinition definition) {
        SnowcastSequencerImpl sequencer = new SnowcastSequencerImpl(sequencerService, definition);
        sequencer.attachLogicalNode();
        return new SequencerProvision(definition, sequencer);
    }
}
