/*
 * Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 * The author licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.microprofile.config.spi;

import java.util.List;

/**
 * <p>Implement this interfaces to provide a ConfigSource provider which
 * is able to maintain multiple ConfigSources. This is e.g. needed if
 * there are multiple property files of a given name.</p>
 * 
 * <p>If a ConfigSource like JNDI only exists once, then there is no need
 * to implement it via the ConfigSourceProvider but should directly
 * expose a {@link ConfigSource}.</p>
 *
 * <p>A ConfigSourceProvider will get picked up via the
 * {@link java.util.ServiceLoader} mechanism and must get registered via
 * META-INF/services/javax.config.spi.ConfigSourceProvider</p>
 *
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 */
public interface ConfigSourceProvider
{

    /**
     * @param forClassLoader the classloader which should be used if any is needed
     *
     * @return For each e.g. property file, we return a single ConfigSource or an empty list if no ConfigSource exists.
     */
    List<ConfigSource> getConfigSources(ClassLoader forClassLoader);
}
