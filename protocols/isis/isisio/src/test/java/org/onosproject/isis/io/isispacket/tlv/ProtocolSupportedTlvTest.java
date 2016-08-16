/*
 * Copyright 2016-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.isis.io.isispacket.tlv;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Unit test class for ProtocolSupportedTlv.
 */
public class ProtocolSupportedTlvTest {
    private final byte[] tlv = {0};
    private ProtocolSupportedTlv protocolSupportedTlv;
    private TlvHeader tlvHeader;
    private List<Byte> supported;
    private ChannelBuffer channelBuffer;
    private byte[] result;

    @Before
    public void setUp() throws Exception {
        tlvHeader = new TlvHeader();
        protocolSupportedTlv = new ProtocolSupportedTlv(tlvHeader);
    }

    @After
    public void tearDown() throws Exception {
        tlvHeader = null;
        protocolSupportedTlv = null;
        channelBuffer = null;
    }

    /**
     * Tests addProtocolSupported() method.
     */
    @Test
    public void testAddProtocolSupported() throws Exception {
        protocolSupportedTlv.addProtocolSupported((byte) 1);
        supported = protocolSupportedTlv.protocolSupported();
        assertThat(supported.size(), is(1));
    }

    /**
     * Tests addProtocolSupported() getter method.
     */
    @Test
    public void testProtocolSupported() throws Exception {
        protocolSupportedTlv.addProtocolSupported((byte) 1);
        supported = protocolSupportedTlv.protocolSupported();
        assertThat(supported.size(), is(1));
    }

    /**
     * Tests readFrom() method.
     */
    @Test
    public void testReadFrom() throws Exception {
        channelBuffer = ChannelBuffers.copiedBuffer(tlv);
        protocolSupportedTlv.readFrom(channelBuffer);
        supported = protocolSupportedTlv.protocolSupported();
        assertThat(supported.size(), is(1));
    }

    /**
     * Tests asBytes() method.
     */
    @Test
    public void testAsBytes() throws Exception {
        channelBuffer = ChannelBuffers.copiedBuffer(tlv);
        protocolSupportedTlv.readFrom(channelBuffer);
        result = protocolSupportedTlv.asBytes();
        assertThat(result, is(notNullValue()));
    }

    /**
     * Tests toString() method.
     */
    @Test
    public void testToString() throws Exception {
        assertThat(protocolSupportedTlv.toString(), is(notNullValue()));
    }
}