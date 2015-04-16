/*
 * Copyright 2015 Higher Frequency Trading
 *
 * http://www.higherfrequencytrading.com
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

package net.openhft.chronicle.engine.client.internal;

import net.openhft.chronicle.engine.client.ClientWiredStatelessTcpConnectionHub;
import net.openhft.chronicle.engine.client.ParameterizeWireKey;
import net.openhft.chronicle.map.AbstactStatelessClient;
import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.Excerpt;
import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.wire.ValueOut;
import net.openhft.chronicle.wire.WireKey;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * Created by Rob Austin
 */
public class ClientWiredChronicleQueueStateless extends AbstactStatelessClient implements ChronicleQueue {

    public ClientWiredChronicleQueueStateless(ClientWiredStatelessTcpConnectionHub hub, String name) {
        super(name, hub, "QUEUE", 0);
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("todo");
    }

    @NotNull
    @Override
    public Excerpt createExcerpt() throws IOException {
        throw new UnsupportedOperationException("todo");
    }

    @NotNull
    @Override
    public ExcerptTailer createTailer() throws IOException {
        throw new UnsupportedOperationException("todo");

    }

    @NotNull
    @Override
    public ExcerptAppender createAppender() throws IOException {
        throw new UnsupportedOperationException("todo");

    }

    @Override
    public long size() {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public long firstAvailableIndex() {
        throw new UnsupportedOperationException("todo");
    }


    @Override
    public void close() throws IOException {
        // todo add ref count
    }

    public long lastWrittenIndex() {
        return proxyReturnLong(EventId.lastWrittenIndex);
    }


    @Override
    protected Consumer<ValueOut> toParameters(@NotNull ParameterizeWireKey eventId, Object... args) {
        throw new UnsupportedOperationException("todo");
    }

    enum EventId implements ParameterizeWireKey {
        lastWrittenIndex;

        private final WireKey[] params;

        <P extends WireKey> EventId(P... params) {
            this.params = params;
        }

        public <P extends WireKey> P[] params() {
            return (P[]) this.params;
        }
    }

}
