/***
 * 
 * @author Moritz
 *
 */
public class BitOrientedOperations { // operations that start with 01
	static int[] bitmask = { 0x7F, 0x380 };
	static int f, b, result, mask;
	
	// bit clear f
	// status affected: none
	public static void BCF(int hexInt) {
		f = hexInt & bitmask[0]; // select f out of the hexInt
		b = (hexInt & bitmask[1]) >>> 7; // select b out of the hexInt and rotate 7 times to the right
		if (f == 0) {
			f = RAM.getFSR();
		}
		result = RAM.getRegisterContent(f);
		mask = 0b01 << b;
		// clear bit b in f
		result = result & ~mask;
		RAM.setRegisterContent(result, f);
	}

	// bit set f
	// status affected: none
	public static void BSF(int hexInt) {
		f = hexInt & bitmask[0]; // select f out of the hexInt
		b = (hexInt & bitmask[1]) >>> 7; // select b out of the hexInt and rotate 7 times to the right
		if (f == 0) {
			f = RAM.getFSR();
		}
		result = RAM.getRegisterContent(f);
		mask = 0b01 << b;
		// set bit b in f
		result = result | mask;
		RAM.setRegisterContent(result, f);
	}

	// bit test, skip if clear
	// status affected: none
	public static void BTFSC(int hexInt) {
		f = hexInt & bitmask[0]; // select f out of the hexInt
		b = (hexInt & bitmask[1]) >>> 7; // select b out of the hexInt and rotate 7 times to the right
		if (f == 0) {
			f = RAM.getFSR();
		}
		result = RAM.getRegisterContent(f);
		mask = 0b01 << b;
		// check if bit b in f is null
		if ((result & mask) == 0) {
			RAM.setPCL(RAM.getPCL()+1);
			// dont do the next operation
		}
	}

	// bit test f, skip if set
	// status affected: none
	public static void BTFSS(int hexInt) {
		f = hexInt & bitmask[0]; // select f out of the hexInt
		b = (hexInt & bitmask[1]) >>> 7; // select b out of the hexInt and rotate 7 times to the right
		if (f == 0) {
			f = RAM.getFSR();
		}
		result = RAM.getRegisterContent(f);
		mask = 0b01 << b;
		// check if bit b in f is not null
		if ((result & mask) != 0) {
			RAM.setPCL(RAM.getPCL()+1);
			// dont do the next operation
		}
	}

	// status affected: none
	public static void NOP() {
		// TODO Auto-generated method stub
	}
}
