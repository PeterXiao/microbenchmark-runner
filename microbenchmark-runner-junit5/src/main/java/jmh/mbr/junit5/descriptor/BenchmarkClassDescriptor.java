/*
 * Copyright 2018 the original author or authors.
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
package jmh.mbr.junit5.descriptor;

import jmh.mbr.core.model.BenchmarkClass;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.ClassSource;

/**
 * {@link org.junit.platform.engine.TestDescriptor} for a {@link BenchmarkClass}.
 *
 * @author Mark Paluch
 */
public class BenchmarkClassDescriptor extends AbstractBenchmarkDescriptor {


	private final BenchmarkClass benchmarkClass;

	public BenchmarkClassDescriptor(UniqueId uniqueId, BenchmarkClass benchmarkClass) {

		super(uniqueId, benchmarkClass.getJavaClass().getName(), ClassSource.from(benchmarkClass.getJavaClass()));
		this.benchmarkClass = benchmarkClass;
	}

	/*
	 * (non-Javadoc)
	 * @see org.junit.platform.engine.TestDescriptor#getType()
	 */
	@Override
	public Type getType() {
		return Type.CONTAINER;
	}

	public BenchmarkClass getBenchmarkClass() {
		return benchmarkClass;
	}

	public Class<?> getJavaClass() {
		return benchmarkClass.getJavaClass();
	}
}
