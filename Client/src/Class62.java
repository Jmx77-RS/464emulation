/* Class62 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class62 {
	public static Class13 aClass13_1225;
	public static Class19 aClass19_1240;
	public static Class26 aClass26_1226;
	public static Class26 aClass26_1229 = RS2Font.getRs2PreparedString("OFF",
			false);
	public static Class26 aClass26_1230;
	public static Class26 aClass26_1232;
	public static Class26 aClass26_1236;
	public static Class26 aClass26_1238;
	public static Class26 aClass26_1239;
	public static Class66 aClass66_1231;
	public static int anInt1224;
	public static int anInt1227;
	public static int anInt1228;
	public static int anInt1234;
	public static int anInt1235;
	public static int anInt1237;
	public static int anInt1241;
	public static int[] anIntArray1233;
	static {
		anInt1227 = 0;
		aClass26_1232 = RS2Font.getRs2PreparedString("red:", false);
		aClass26_1226 = aClass26_1232;
		aClass26_1236 = aClass26_1232;
		aClass26_1230 = RS2Font.getRs2PreparedString("<col=ff9040>", false);
		aClass26_1238 = aClass26_1229;
		aClass66_1231 = new Class66(200);
		aClass26_1239 = null;
		anInt1241 = 0;
	}

	public static void method1048(boolean arg0, int arg1) {
		try {
			if (arg0 != false)
				aClass26_1232 = null;
			anInt1235++;
			if (arg1 != -1 && Class4_Sub12.method277((byte) 125, arg1)) {
				RSInterface[] class4_sub13s = Class28.aClass4_Sub13ArrayArray632[arg1];
				for (int i = 0; class4_sub13s.length > i; i++) {
					RSInterface class4_sub13 = class4_sub13s[i];
					if (class4_sub13.anObjectArray2242 != null) {
						Class4_Sub14 class4_sub14 = new Class4_Sub14();
						class4_sub14.anObjectArray2267 = class4_sub13.anObjectArray2242;
						class4_sub14.aClass4_Sub13_2282 = class4_sub13;
						Class16.method721(1, class4_sub14);
					}
				}
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, ("rf.C("
					+ arg0 + ',' + arg1 + ')'));
		}
	}

	public static void method1049(int arg0, int arg1, int arg2) {
		try {
			Class65 class65 = (Class40.aClass65ArrayArrayArray787[Class82.anInt1711][arg1][arg0]);
			anInt1228++;
			if (class65 == null)
				Class4_Sub20_Sub7_Sub6.aClass69_3439.method1122(
						Class82.anInt1711, arg1, arg0);
			else {
				int i = -99999999;
				Class4_Sub20_Sub7_Sub4 class4_sub20_sub7_sub4 = null;
				for (Class4_Sub20_Sub7_Sub4 class4_sub20_sub7_sub4_3_ = ((Class4_Sub20_Sub7_Sub4) class65
						.method1071(arg2 ^ ~0x3a)); class4_sub20_sub7_sub4_3_ != null; class4_sub20_sub7_sub4_3_ = ((Class4_Sub20_Sub7_Sub4) class65
						.method1075(arg2 + 18421))) {
					Class4_Sub20_Sub8 class4_sub20_sub8 = Class4_Sub23
							.method633((class4_sub20_sub7_sub4_3_.anInt3379),
									(byte) -124);
					int i_4_ = class4_sub20_sub8.anInt3017;
					if (class4_sub20_sub8.anInt3012 == 1)
						i_4_ *= class4_sub20_sub7_sub4_3_.anInt3378 - -1;
					if (i < i_4_) {
						class4_sub20_sub7_sub4 = class4_sub20_sub7_sub4_3_;
						i = i_4_;
					}
				}
				if (class4_sub20_sub7_sub4 == null)
					Class4_Sub20_Sub7_Sub6.aClass69_3439.method1122(
							Class82.anInt1711, arg1, arg0);
				else {
					class65.method1077(false, class4_sub20_sub7_sub4);
					Class4_Sub20_Sub7_Sub4 class4_sub20_sub7_sub4_5_ = (Class4_Sub20_Sub7_Sub4) class65
							.method1071(-128);
					Class4_Sub20_Sub7_Sub4 class4_sub20_sub7_sub4_6_ = null;
					int i_7_ = arg1 - -(arg0 << 839433799) - -1610612736;
					Class4_Sub20_Sub7_Sub4 class4_sub20_sub7_sub4_8_ = null;
					for (/**/; class4_sub20_sub7_sub4_5_ != null; class4_sub20_sub7_sub4_5_ = ((Class4_Sub20_Sub7_Sub4) class65
							.method1075(arg2 + 18421))) {
						if ((class4_sub20_sub7_sub4.anInt3379 ^ 0xffffffff) != (class4_sub20_sub7_sub4_5_.anInt3379 ^ 0xffffffff)) {
							if (class4_sub20_sub7_sub4_6_ == null)
								class4_sub20_sub7_sub4_6_ = class4_sub20_sub7_sub4_5_;
							if (((class4_sub20_sub7_sub4_6_.anInt3379 ^ 0xffffffff) != (class4_sub20_sub7_sub4_5_.anInt3379 ^ 0xffffffff))
									&& class4_sub20_sub7_sub4_8_ == null)
								class4_sub20_sub7_sub4_8_ = class4_sub20_sub7_sub4_5_;
						}
					}
					Class4_Sub20_Sub7_Sub6.aClass69_3439.method1119(
							Class82.anInt1711,
							arg1,
							arg0,
							Class67.method1090(arg1 * 128 + arg2, arg0 * 128
									- -64, true, Class82.anInt1711),
							class4_sub20_sub7_sub4, i_7_,
							class4_sub20_sub7_sub4_6_,
							class4_sub20_sub7_sub4_8_);
				}
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, ("rf.E("
					+ arg0 + ',' + arg1 + ',' + arg2 + ')'));
		}
	}

	public static void method1050(boolean arg0) {
		try {
			anInt1237++;
			Class14.method701(-1);
			Class4_Sub17.method308(false);
			Class9.method663(-18722);
			Class47.method976((byte) 86);
			Class38.method921(-19752);
			Class4_Sub20_Sub6.method370(-113);
			ByteBuffer.method268(28317);
			Class50.method995(114);
			Class4_Sub20_Sub7_Sub5.method428(1);
			Class4_Sub16.method302(25947);
			Class47.method981(0);
			Class68.method1095(2);
			((Class34) Class4_Sub20_Sub12_Sub3.anInterface2_3530).method890(0);
			if (arg0 != true)
				method1050(true);
			Class4_Sub14.aClass66_2286.method1084(0);
			Class73.aClass19_Sub1_1504.method736(0);
			Class4_Sub1.aClass19_Sub1_1861.method736(0);
			Class4_Sub17.aClass19_Sub1_2321.method736(0);
			Class66.aClass19_Sub1_1336.method736(0);
			Class4_Sub20_Sub6.aClass19_Sub1_2911.method736(0);
			Class54.aClass19_Sub1_1107.method736(0);
			Class4_Sub24.aClass19_Sub1_2451.method736(0);
			Client.aClass19_Sub1_1849.method736(0);
			Class18.aClass19_Sub1_482.method736(0);
			Class77.aClass19_Sub1_1589.method736(0);
			Class24.aClass19_Sub1_562.method736(0);
			Class4_Sub20_Sub14.aClass19_Sub1_3146.method736(0);
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, "rf.A("
					+ arg0 + ')');
		}
	}

	public static void method1052(boolean arg0) {
		try {
			aClass26_1239 = null;
			if (arg0 == true) {
				aClass13_1225 = null;
				anIntArray1233 = null;
				aClass26_1232 = null;
				aClass19_1240 = null;
				aClass26_1236 = null;
				aClass26_1229 = null;
				aClass26_1226 = null;
				aClass26_1230 = null;
				aClass66_1231 = null;
				aClass26_1238 = null;
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, "rf.B("
					+ arg0 + ')');
		}
	}

	public int[] anIntArray1223;

	public Class62(int[] arg0) {
		try {
			int i;
			for (i = 1; ((arg0.length + (arg0.length >> 557323841) ^ 0xffffffff) <= (i ^ 0xffffffff)); i <<= 1) {
				/* empty */
			}
			anIntArray1223 = new int[i - -i];
			for (int i_0_ = 0; i + i > i_0_; i_0_++)
				anIntArray1223[i_0_] = -1;
			for (int i_1_ = 0; (arg0.length ^ 0xffffffff) < (i_1_ ^ 0xffffffff); i_1_++) {
				int i_2_;
				for (i_2_ = i - 1 & arg0[i_1_]; (anIntArray1223[i_2_ - -i_2_
						- -1] ^ 0xffffffff) != 0; i_2_ = i_2_ - -1 & -1 + i) {
					/* empty */
				}
				anIntArray1223[i_2_ + i_2_] = arg0[i_1_];
				anIntArray1223[1 + i_2_ + i_2_] = i_1_;
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception,
					("rf.<init>(" + (arg0 != null ? "{...}" : "null") + ')'));
		}
	}

	public int method1051(int arg0, byte arg1) {
		try {
			anInt1224++;
			int i = anIntArray1223.length - 2;
			if (arg1 > -120)
				aClass19_1240 = null;
			int i_9_ = arg0 << -2048114559 & i;
			for (;;) {
				int i_10_ = anIntArray1223[i_9_];
				if (i_10_ == arg0)
					return anIntArray1223[i_9_ + 1];
				if ((i_10_ ^ 0xffffffff) == 0)
					return -1;
				i_9_ = i & i_9_ - -2;
			}
		} catch (RuntimeException runtimeexception) {
			throw Class4_Sub20_Sub7_Sub4.method423(runtimeexception, ("rf.D("
					+ arg0 + ',' + arg1 + ')'));
		}
	}
}
