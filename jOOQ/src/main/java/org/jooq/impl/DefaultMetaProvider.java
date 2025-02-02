/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import java.sql.DatabaseMetaData;

import org.jooq.Configuration;
import org.jooq.Meta;
import org.jooq.MetaProvider;
import org.jooq.tools.JooqLogger;

/**
 * A default implementation of the {@link MetaProvider} SPI, which provides meta
 * data information based on the JDBC {@link DatabaseMetaData} API.
 *
 * @author Lukas Eder
 */
public class DefaultMetaProvider implements MetaProvider {

    private static final JooqLogger log = JooqLogger.getLogger(DefaultMetaProvider.class);
    private final Configuration     configuration;

    public DefaultMetaProvider(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Meta provide() {
        return new MetaImpl(configuration, null);
    }

    /**
     * Get a {@link Meta} that doesn't fail if it is not connected.
     */
    static Meta meta(Configuration configuration) {
        Meta meta = configuration.metaProvider().provide();

        if (meta instanceof MetaImpl && configuration.connectionProvider() instanceof NoConnectionProvider) {
            log.debug("No MetaProvider configured. For best results when looking up meta data, configure a MetaProvider, or connect to a database");
            return configuration.dsl().meta("");
        }
        else
            return meta;
    }
}
