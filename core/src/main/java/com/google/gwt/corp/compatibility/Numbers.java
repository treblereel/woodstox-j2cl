/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gwt.corp.compatibility;

import org.gwtproject.typedarrays.client.Float32ArrayNative;
import org.gwtproject.typedarrays.client.Float64ArrayNative;
import org.gwtproject.typedarrays.client.Int32ArrayNative;
import org.gwtproject.typedarrays.client.Int8ArrayNative;
import org.gwtproject.typedarrays.shared.Float32Array;
import org.gwtproject.typedarrays.shared.Float64Array;
import org.gwtproject.typedarrays.shared.Int32Array;
import org.gwtproject.typedarrays.shared.Int8Array;

public final class Numbers {
	
	public static int floatToIntBits (float f) {
		wfa.set(0, f);
		return wia.get(0);
	}

	private static final Int8Array wba = Int8ArrayNative.create(8);
	private static final Int32Array wia = Int32ArrayNative.create(wba.buffer(), 0, 2);
	private static final Float32Array wfa = Float32ArrayNative.create(wba.buffer(), 0, 1);
	private static final Float64Array wda = Float64ArrayNative.create(wba.buffer(), 0, 1);

	public static float intBitsToFloat (int i) {
		wia.set(0, i);
		return wfa.get(0);
	}

	public static long doubleToLongBits (double d) {
		wda.set(0, d);
		return ((long)wia.get(1) << 32) | (wia.get(0) & 0xffffffffL);
	}

	public static double longBitsToDouble (long l) {
		wia.set(1, (int)(l >>> 32));
		wia.set(0, (int)(l & 0xffffffffL));
		return wda.get(0);
	}

	public static long doubleToRawLongBits (double d) {
		wda.set(0, d);
		return ((long)wia.get(1) << 32) | (wia.get(0) & 0xffffffffL);
	}
}
