package Problem2;

import Problem1.CDF24;
import Problem1.Utils;

public class Ripples_F_ex_4_4_p34 extends Function {
	public static enum DWT {CDF44, HWT};
	public static enum COEFF {S, D};

	static final int D10_START_1024 = 512;
	static final int D10_END_1024 = 1023;

	static final int D9_START_1024 = 256;
	static final int D9_END_1024 = 511;

	static final int D8_START_1024 = 128;
	static final int D8_END_1024 = 255;

	static final int D7_START_1024 = 64;
	static final int D7_END_1024 = 127;

	static final int D6_START_1024 = 32;
	static final int D6_END_1024 = 63;

	static final int S6_START_1024 = 0;
	static final int S6_END_1024 = 31;
	
	static double[] sDomain = partition(0, 511, 1);
	static double[] sRangeFig_4_12_p33 = new double[1024];
	static Ripples_F_p33 sRipples_F_p33 = new Ripples_F_p33();
	
	public final static double FSNORM = Math.sqrt(2);
    public final static double FDNORM = 1/FSNORM;

	@Override
	public double v(double t) {
		if (0 <= t && t < 0.25) {
			return Math.sin(4*Math.PI*t);
		} else if (0.25 <= t && t < 0.75) {
			return 1 + Math.sin(4*Math.PI*t);
		} else if (0.75 <= t && t <= 1) {
			return Math.sin(4*Math.PI*t);
		} else {
			throw new IllegalArgumentException("t == " + t);
		}
	}

	static void multires_fig_4_13_cdf_p34(String message, int range_start, int range_end) {
		multires_fig_4_13_p34_aux(message, DWT.CDF44, 6, range_start, range_end);
	}

	static void multires_fig_4_13_hwt_p34(String message, int range_start, int range_end) {
		multires_fig_4_13_p34_aux(message, DWT.HWT, 6, range_start, range_end);
	}

	static void multires_fig_4_13_p34_aux(String message, DWT dwt, int num_iters, int range_start, int range_end) {
		for(int i = 0; i < 1024; i++)  {
			sRangeFig_4_12_p33[i] = sRipples_F_p33.v(sDomainFig_4_12_p33[i]);
		}

		for(int i = 1; i < 1024; i += 32) {
			sRangeFig_4_12_p33[i] += 2;
		}

		//final int NUM_ITERS = 6;
		forwardDWTForNumIters(sRangeFig_4_12_p33, dwt, num_iters, range_start, range_end);

		//CDF44.orderedDWTForNumIters(sRangeFig_4_12_p33, 6, false);

		double[] signal = new double[sRangeFig_4_12_p33.length];
		for(int i = 0; i < 1024; i++) {
			if ( i >= range_start && i <= range_end ) {
				signal[i] = sRangeFig_4_12_p33[i];
			}
			else {
				signal[i] = 0;
			}
		}

		System.out.println("=========================");
		System.out.println(message);
		//display_signal(signal);
		System.out.println("Inversed Signal");
		System.out.println("=========================");

		inverseDWTForNumIters(signal, dwt, num_iters);
		//CDF44.orderedInverseDWTForNumIters(signal, 6, false);

		//display_signal(signal);
		System.out.println("=========================");
	}

	static void fig_4_13_D10_CDF44_p34() {
		multires_fig_4_13_cdf_p34("Fig. 4.13, 06-06-07-08-09-D10, CDF(4,4) p. 33", D10_START_1024, D10_END_1024);
	}

	static void fig_4_13_D10_HWT_p34() {
		multires_fig_4_13_hwt_p34("Fig. 4.13, 06-06-07-08-09-D10, HWT, p. 33", D10_START_1024, D10_END_1024);
	}

	static void fig_4_13_D9_CDF44_p34() {
		multires_fig_4_13_cdf_p34("Fig. 4.13, 06-06-07-08-D9-010, CDF(4,4), p. 33", D9_START_1024, D9_END_1024);
	}

	static void fig_4_13_D9_HWT_p34() {
		multires_fig_4_13_hwt_p34("Fig. 4.13, 06-06-07-08-D9-010, HWT, p. 33", D9_START_1024, D9_END_1024);
	}

	static void fig_4_13_D8_CDF44_p34() {
		multires_fig_4_13_cdf_p34("Fig. 4.13, 06-06-07-D8-09-010, CDF(4,4), p. 33", D8_START_1024, D8_END_1024);
	}

	static void fig_4_13_D8_HWT_p34() {
		multires_fig_4_13_hwt_p34("Fig. 4.13, 06-06-07-D8-09-010, HWT, p. 33", D8_START_1024, D8_END_1024);
	}

	static void fig_4_13_D7_CDF44_p34() {
		multires_fig_4_13_cdf_p34("Fig. 4.13, 06-06-D7-08-09-010, CDF(4,4), p. 33", D7_START_1024, D7_END_1024);
	}

	static void fig_4_13_D7_HWT_p34() {
		multires_fig_4_13_hwt_p34("Fig. 4.13, 06-06-D7-08-09-010, HWT, p. 33", D7_START_1024, D7_END_1024);
	}

	static void fig_4_13_D6_CDF44_p34() {
		multires_fig_4_13_cdf_p34("Fig. 4.13, 06-D6-07-08-09-010, CDF(4,4), p. 33", D6_START_1024, D6_END_1024);
	}

	static void fig_4_13_D6_HWT_p34() {
		multires_fig_4_13_hwt_p34("Fig. 4.13, 06-D6-07-08-09-010, HWT, p. 33", D6_START_1024, D6_END_1024);
	}

	static void fig_4_13_S6_CDF44_p34() {
		multires_fig_4_13_cdf_p34("Fig. 4.13, S6-06-07-08-09-010, CDF(4,4), p. 33", S6_START_1024, S6_END_1024);
	}

	static void fig_4_13_S6_HWT_p34() {
		multires_fig_4_13_hwt_p34("Fig. 4.13, S6-06-07-08-09-010, HWT, p. 33", S6_START_1024, S6_END_1024);
	}
	
	public static double[] partition(double from, double upto, double step) {
        if ( upto <= from ) return null;
        int n = (int)((upto - from)/step) + 1;
        double[] interval = new double[n];
       
        int i;
        double curr;
        for(i = 0, curr = from; i < n; i++, curr += step) {
            interval[i] = curr;
        }
        return interval;
    }
	
	public static void forwardDWTForNumIters(double[] signal, DWT dwt, int num_iters, int range_start, int range_end) {
        if ( dwt == DWT.CDF44 ) {
            CDF24.ordDWTForNumIters(signal, num_iters);
        }
        else if ( dwt == DWT.HWT ) {
            orderedNormalizedFastHaarWaveletTransformForNumIters(signal, num_iters);
        }
        else {
            throw new IllegalArgumentException("Illegal dwt value: " + dwt);
        }
    }
	
	public static void inverseDWTForNumIters(double[] signal, DWT dwt, int num_iters) {
        if ( dwt == DWT.CDF44 ) {
            CDF24.ordInvDWTForNumIters(signal, num_iters);
        }
        else if ( dwt == DWT.HWT ) {
            orderedNormalizedFastInverseHaarWaveletTransformForNumIters(signal, num_iters);
        }
        else {
            throw new IllegalArgumentException("Illegal dwt value: " + dwt);
        }
    }
	
	public static void orderedNormalizedFastHaarWaveletTransformForNumIters(double[] sample, int num_iters) {
        final int n = sample.length;
        if ( !Utils.isPowerOf2(n) ) return;
        final int NUM_SWEEPS = (int) (Math.log(n) / Math.log(2.0));
        if ( num_iters > NUM_SWEEPS ) return;
        double acoeff, ccoeff;
        if ( NUM_SWEEPS == 1 ) {
            acoeff = FSNORM * (sample[0] + sample[1])/2.0;
            ccoeff = FDNORM * (sample[0] - sample[1]);
            sample[0] = acoeff;
            sample[1] = ccoeff;
            return;
        }
        double[] acoeffs;
        double[] ccoeffs;
        for (int SWEEP_NUM = 1; SWEEP_NUM <= num_iters; SWEEP_NUM++) {
            int size = (int) Math.pow(2.0, (double) (NUM_SWEEPS - SWEEP_NUM)); 
            acoeffs = new double[size]; // where we place a-coefficients
            ccoeffs = new double[size]; // where we place c-coefficients
            int ai = 0; // index over acoeffs
            int ci = 0; // index over ccoeffs
            int end = ((int) Math.pow(2.0, (double) (NUM_SWEEPS - SWEEP_NUM + 1))) - 1;
            for (int i = 0; i <= end; i += 2) {
                acoeffs[ai++] = FSNORM * (sample[i] + sample[i + 1])/2.0;
                ccoeffs[ci++] = FDNORM * (sample[i] - sample[i + 1]);
            }
            
            for (int i = 0; i < size; i++) {
                sample[i] = acoeffs[i];
                sample[i + size] = ccoeffs[i];
            }
        }
    }
	
	public static void orderedNormalizedFastInverseHaarWaveletTransformForNumIters(double[] sample, int num_iters) {
        int n = sample.length;
        if (n < 2 || !Utils.isPowerOf2(n)) {
            return;
        }
        n = (int) (Math.log(n) / Math.log(2.0));
        if (num_iters > n) {
            return;
        }
        double a0 = 0;
        double a1 = 0;
        double[] restored_vals = null;
        int GAP = (int)(Math.pow(2.0, n-num_iters));
        for (int L = 1; L <= num_iters; L++) {
            restored_vals = null;
            restored_vals = new double[2 * GAP]; // restored values at level L
            for (int i = 0; i < GAP; i++) {
                double d = FSNORM * sample[GAP + i];
                double s = FDNORM * sample[i];
                a0 = s + d/2;
                a1 = s - d/2;
                restored_vals[2 * i] = a0;
                restored_vals[2 * i + 1] = a1;
            }
            System.arraycopy(restored_vals, 0, sample, 0, 2 * GAP);
            GAP *= 2;
        }
    }
	
	static public class Ripples_F_p33 extends Function {
	    
	    public Ripples_F_p33() {}
	    @Override
	    public double v(double t) { return Math.log(2.0 + Math.sin(3 * Math.PI * Math.sqrt(t))); } 
	    
	}
}