/* Class10 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class10 {
	public static Class26 aClass26_287 = RS2Font.getRs2PreparedString("flash2:",
			false);
	public static Class26 aClass26_295 = aClass26_287;
	public static Class26 aClass26_297 = aClass26_287;
	public static Class26 aClass26_300;
	public static Class26 aClass26_301 = RS2Font.getRs2PreparedString(")4l",
			false);
	public static Class26 aClass26_302;
	public static Class26 aClass26_303;
	public static Class26 aClass26_304;
	public static Class26 aClass26_308;
	public static Class26 aClass26_309;
	public static Class26 aClass26_310;
	public static Class26 aClass26_311;
	public static Class26 aClass26_312;
	public static Class47 aClass47_305;
	public static Class66 aClass66_299 = new Class66(500);
	public static int anInt286;
	public static int anInt291;
	public static int anInt292;
	public static int anInt293;
	public static int anInt296;
	public static int anInt298;
	public static int anInt306;
	public static int anInt307;
	public static int anInt313;
	static {
		aClass26_300 = RS2Font.getRs2PreparedString("leuchten2:", false);
		aClass26_309 = RS2Font.getRs2PreparedString("va", false);
		aClass26_310 = RS2Font.getRs2PreparedString("Ausw-=hlen", false);
		anInt307 = 0;
		aClass26_304 = RS2Font.getRs2PreparedString(
				"Connecting to server)3)3)3", false);
		anInt306 = 0;
		aClass26_308 = RS2Font.getRs2PreparedString("http:)4)4", false);
		aClass26_311 = aClass26_304;
		aClass26_302 = RS2Font.getRs2PreparedString(
				"Der Server wird gerade aktualisiert)3", false);
		aClass26_303 = RS2Font.getRs2PreparedString("<col=00ffff>", false);
		aClass26_312 = (RS2Font.getRs2PreparedString(
				" steht bereits auf Ihrer Ignorieren)2Liste(Q", false));
		anInt313 = 0;
	}

	public static void method667(int arg0) {
		try {
			aClass26_309 = null;
			aClass26_303 = null;
			aClass26_304 = null;
			aClass26_308 = null;
			aClass26_300 = null;
			aClass26_297 = null;
			if (arg0 == 0) {
				aClass26_287 = null;
				aClass26_312 = null;
				aClass26_301 = null;
				aClass26_310 = null;
				aClass26_295 = null;
				aClass26_302 = null;
				aClass66_299 = null;
				aClass47_305 = null;
				aClass26_311 = null;
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, "cb.A("
					+ arg0 + ')');
		}
	}

	public static void method669(int arg0) {
		try {
			int i = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883.method266(
					-1432215741, 8);
			if (Class4_Sub20_Sub7_Sub6.anInt3431 > i) {
				for (int i_6_ = i; i_6_ < Class4_Sub20_Sub7_Sub6.anInt3431; i_6_++)
					Class58.anIntArray1164[Class4_Sub20_Sub7_Sub5.anInt3386++] = Class4_Sub23.anIntArray2432[i_6_];
			}
			anInt298++;
			if ((Class4_Sub20_Sub7_Sub6.anInt3431 ^ 0xffffffff) > (i ^ 0xffffffff))
				throw new RuntimeException("gppov1");
			Class4_Sub20_Sub7_Sub6.anInt3431 = arg0;
			for (int i_7_ = 0; i_7_ < i; i_7_++) {
				int i_8_ = Class4_Sub23.anIntArray2432[i_7_];
				Class4_Sub20_Sub7_Sub1_Sub1 class4_sub20_sub7_sub1_sub1 = (Class4_Sub20_Sub7_Sub4.aClass4_Sub20_Sub7_Sub1_Sub1Array3358[i_8_]);
				int i_9_ = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883.method266(
						-1432215741, 1);
				if ((i_9_ ^ 0xffffffff) == -1) {
					Class4_Sub23.anIntArray2432[Class4_Sub20_Sub7_Sub6.anInt3431++] = i_8_;
					class4_sub20_sub7_sub1_sub1.anInt3256 = Region.anInt134;
				} else {
					int i_10_ = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883
							.method266(-1432215741, 2);
					if (i_10_ == 0) {
						Class4_Sub23.anIntArray2432[Class4_Sub20_Sub7_Sub6.anInt3431++] = i_8_;
						class4_sub20_sub7_sub1_sub1.anInt3256 = Region.anInt134;
						Class48.anIntArray979[JagexException.anInt1726++] = i_8_;
					} else if (i_10_ == 1) {
						Class4_Sub23.anIntArray2432[Class4_Sub20_Sub7_Sub6.anInt3431++] = i_8_;
						class4_sub20_sub7_sub1_sub1.anInt3256 = Region.anInt134;
						int i_11_ = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883
								.method266(-1432215741, 3);
						class4_sub20_sub7_sub1_sub1.method386(false, false,
								i_11_);
						int i_12_ = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883
								.method266(arg0 ^ ~0x555de0bc, 1);
						if ((i_12_ ^ 0xffffffff) == -2)
							Class48.anIntArray979[JagexException.anInt1726++] = i_8_;
					} else if ((i_10_ ^ 0xffffffff) == -3) {
						Class4_Sub23.anIntArray2432[Class4_Sub20_Sub7_Sub6.anInt3431++] = i_8_;
						class4_sub20_sub7_sub1_sub1.anInt3256 = Region.anInt134;
						int i_13_ = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883
								.method266(-1432215741, 3);
						class4_sub20_sub7_sub1_sub1.method386(false, true,
								i_13_);
						int i_14_ = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883
								.method266(-1432215741, 3);
						class4_sub20_sub7_sub1_sub1.method386(false, true,
								i_14_);
						int i_15_ = Class4_Sub20_Sub5.aClass4_Sub11_Sub1_2883
								.method266(-1432215741, 1);
						if (i_15_ == 1)
							Class48.anIntArray979[JagexException.anInt1726++] = i_8_;
					} else if ((i_10_ ^ 0xffffffff) == -4)
						Class58.anIntArray1164[Class4_Sub20_Sub7_Sub5.anInt3386++] = i_8_;
				}
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, "cb.F("
					+ arg0 + ')');
		}
	}

	public static Class26[] method671(boolean arg0, Class26[] arg1) {
		try {
			Class26[] class26s = new Class26[5];
			for (int i = 0; (i ^ 0xffffffff) > -6; i++) {
				class26s[i] = Class4_Sub24.method639(
						(new Class26[] { Class74.method1168(-96, i),
								Class4_Sub10.aClass26_2047 }), -842);
				if (arg1 != null && arg1[i] != null)
					class26s[i] = Class4_Sub24.method639(new Class26[] {
							class26s[i], arg1[i] }, -842);
			}
			if (arg0 != false)
				aClass26_300 = null;
			anInt292++;
			return class26s;
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, ("cb.C("
					+ arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
		}
	}

	public Class27 aClass27_289 = null;

	public Class27 aClass27_294 = null;

	public int anInt288;

	public int anInt290;

	public Class10(int arg0, Class27 arg1, Class27 arg2, int arg3) {
		anInt290 = 65000;
		try {
			aClass27_294 = arg1;
			anInt290 = arg3;
			aClass27_289 = arg2;
			anInt288 = arg0;
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4
					.method423(runtimeexception,
							("cb.<init>(" + arg0 + ','
									+ (arg1 != null ? "{...}" : "null") + ','
									+ (arg2 != null ? "{...}" : "null") + ','
									+ arg3 + ')'));
		}
	}

	public boolean method666(int arg0, int arg1, int arg2, byte[] arg3) {
		try {
			anInt291++;
			synchronized (aClass27_294) {
				if (arg0 < 0 || (anInt290 ^ 0xffffffff) > (arg0 ^ 0xffffffff))
					throw new IllegalArgumentException();
				boolean bool = method668(arg0, arg1, arg2 + -27208, true, arg3);
				if (arg2 != 27463)
					method667(-108);
				if (!bool)
					bool = method668(arg0, arg1, 255, false, arg3);
				return bool;
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, ("cb.D("
					+ arg0 + ',' + arg1 + ',' + arg2 + ','
					+ (arg3 != null ? "{...}" : "null") + ')'));
		}
	}

	public boolean method668(int arg0, int arg1, int arg2, boolean arg3,
			byte[] arg4) {
		try {
			anInt296++;
			synchronized (aClass27_294) {
				try {
					int i;
					if (!arg3) {
						i = (int) ((aClass27_294.method846(31549) - -519L) / 520L);
						if (i == 0)
							i = 1;
					} else {
						if (aClass27_289.method846(arg2 + 31294) < (arg1 * 6 + 6))
							return false;
						aClass27_289.method853((byte) -75, (6 * arg1));
						aClass27_289
								.method848(Class8.aByteArray258, 2094, 6, 0);
						i = (((Class8.aByteArray258[4] & 0xff) << 1062745992) + (((0xff & Class8.aByteArray258[3]) << 1731487664) + (Class8.aByteArray258[5] & 0xff)));
						if (i <= 0 || i > aClass27_294.method846(31549) / 520L)
							return false;
					}
					Class8.aByteArray258[3] = (byte) (i >> -585785392);
					Class8.aByteArray258[4] = (byte) (i >> 1581424584);
					int i_0_ = 0;
					Class8.aByteArray258[1] = (byte) (arg0 >> 120321960);
					Class8.aByteArray258[5] = (byte) i;
					if (arg2 != 255)
						aClass26_311 = null;
					int i_1_ = 0;
					Class8.aByteArray258[0] = (byte) (arg0 >> -1773830704);
					Class8.aByteArray258[2] = (byte) arg0;
					aClass27_289.method853((byte) -106, (arg1 * 6));
					aClass27_289.method851(Class8.aByteArray258, -1, 6, 0);
					int i_2_;
					for (/**/; i_0_ < arg0; i_0_ += i_2_) {
						int i_3_ = 0;
						if (arg3) {
							aClass27_294.method853((byte) -103, (520 * i));
							try {
								aClass27_294.method848(Class8.aByteArray258,
										2094, 8, 0);
							} catch (java.io.EOFException eofexception) {
								break;
							}
							i_3_ = ((0xff0000 & Class8.aByteArray258[4] << -2134528688) + (((Class8.aByteArray258[5] & 0xff) << 1686371496) - -(Class8.aByteArray258[6] & 0xff)));
							i_2_ = ((0xff & Class8.aByteArray258[1]) + (0xff00 & (Class8.aByteArray258[0] << -1875166584)));
							int i_4_ = ((0xff & Class8.aByteArray258[3]) + (0xff00 & (Class8.aByteArray258[2] << -898037048)));
							int i_5_ = Class8.aByteArray258[7] & 0xff;
							if (i_2_ != arg1
									|| (i_4_ ^ 0xffffffff) != (i_1_ ^ 0xffffffff)
									|| (i_5_ ^ 0xffffffff) != (anInt288 ^ 0xffffffff))
								return false;
							if ((i_3_ ^ 0xffffffff) > -1
									|| ((i_3_ ^ 0xffffffffffffffffL) < (aClass27_294
											.method846(31549) / 520L ^ 0xffffffffffffffffL)))
								return false;
						}
						i_2_ = arg0 - i_0_;
						if (i_2_ > 512)
							i_2_ = 512;
						if (i_3_ == 0) {
							arg3 = false;
							i_3_ = (int) ((519L + aClass27_294.method846(31549)) / 520L);
							if (i_3_ == 0)
								i_3_++;
							if ((i_3_ ^ 0xffffffff) == (i ^ 0xffffffff))
								i_3_++;
						}
						Class8.aByteArray258[0] = (byte) (arg1 >> -1063382488);
						Class8.aByteArray258[1] = (byte) arg1;
						Class8.aByteArray258[3] = (byte) i_1_;
						Class8.aByteArray258[7] = (byte) anInt288;
						Class8.aByteArray258[2] = (byte) (i_1_ >> 1618808072);
						if (arg0 - i_0_ <= 512)
							i_3_ = 0;
						Class8.aByteArray258[4] = (byte) (i_3_ >> 1258336240);
						Class8.aByteArray258[5] = (byte) (i_3_ >> -1158830968);
						Class8.aByteArray258[6] = (byte) i_3_;
						aClass27_294.method853((byte) -79, (520 * i));
						aClass27_294.method851(Class8.aByteArray258, -1, 8, 0);
						i_1_++;
						aClass27_294.method851(arg4, -1, i_2_, i_0_);
						i = i_3_;
					}
					return true;
				} catch (java.io.IOException ioexception) {
					return false;
				}
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, ("cb.B("
					+ arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ','
					+ (arg4 != null ? "{...}" : "null") + ')'));
		}
	}

	public byte[] method670(int arg0, int arg1) {
		try {
			anInt286++;
			synchronized (aClass27_294) {
				try {
					if ((6 * arg0 + 6) > aClass27_289.method846(31549))
						return null;
					aClass27_289.method853((byte) -118, (arg0 * 6));
					aClass27_289.method848(Class8.aByteArray258, arg1 ^ 0x8d1,
							6, 0);
					int i = ((Class8.aByteArray258[2] & 0xff)
							+ (0xff0000 & Class8.aByteArray258[0] << 1655531248) - -((0xff & Class8.aByteArray258[1]) << 138509800));
					int i_16_ = ((Class8.aByteArray258[5] & arg1) + (((Class8.aByteArray258[4] & 0xff) << -147821880) + ((0xff & Class8.aByteArray258[3]) << -1996174544)));
					if ((i ^ 0xffffffff) > -1 || i > anInt290)
						return null;
					if ((i_16_ ^ 0xffffffff) >= -1
							|| (aClass27_294.method846(arg1 + 31294) / 520L < i_16_))
						return null;
					int i_17_ = 0;
					byte[] is = new byte[i];
					int i_18_ = 0;
					while ((i ^ 0xffffffff) < (i_17_ ^ 0xffffffff)) {
						if (i_16_ == 0)
							return null;
						int i_19_ = i - i_17_;
						if ((i_19_ ^ 0xffffffff) < -513)
							i_19_ = 512;
						aClass27_294.method853((byte) -58, (520 * i_16_));
						aClass27_294.method848(Class8.aByteArray258, 2094,
								i_19_ + 8, 0);
						int i_20_ = 0xff & Class8.aByteArray258[7];
						int i_21_ = (((0xff & Class8.aByteArray258[2]) << -800707704) - -(Class8.aByteArray258[3] & 0xff));
						int i_22_ = ((Class8.aByteArray258[1] & 0xff) + ((0xff & Class8.aByteArray258[0]) << 559664872));
						int i_23_ = (((Class8.aByteArray258[4] & 0xff) << 750609616) + (((0xff & Class8.aByteArray258[5]) << -1626986264) + (Class8.aByteArray258[6] & 0xff)));
						if (arg0 != i_22_
								|| (i_21_ ^ 0xffffffff) != (i_18_ ^ 0xffffffff)
								|| (anInt288 ^ 0xffffffff) != (i_20_ ^ 0xffffffff))
							return null;
						if ((i_23_ ^ 0xffffffff) > -1
								|| (aClass27_294.method846(31549) / 520L < i_23_))
							return null;
						i_16_ = i_23_;
						i_18_++;
						for (int i_24_ = 0; (i_24_ ^ 0xffffffff) > (i_19_ ^ 0xffffffff); i_24_++)
							is[i_17_++] = Class8.aByteArray258[i_24_ + 8];
					}
					return is;
				} catch (java.io.IOException ioexception) {
					return null;
				}
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, ("cb.E("
					+ arg0 + ',' + arg1 + ')'));
		}
	}

	@Override
	public String toString() {
		try {
			anInt293++;
			return "Cache:" + anInt288;
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception,
					"cb.toString(" + ')');
		}
	}
}
