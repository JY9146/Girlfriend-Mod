package dev.vini2003.girlfriend.client.util;

public class DelayUtils {
	private static long delay = 0;
	
	public static long getDelay() {
		return delay;
	}
	
	public static void setDelay(long delay) {
		DelayUtils.delay = delay;
	}
}
