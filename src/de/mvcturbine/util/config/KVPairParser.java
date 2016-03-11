package de.mvcturbine.util.config;

/**
 * Simple key value pair parser
 * 
 * @author tsys
 *
 */
public class KVPairParser
{
	/** The KV pair separator */
	private final String separator;

	/**
	 * Initializes a new key value pair parser with the given {@code separator}
	 * 
	 * @param seperator
	 */
	public KVPairParser(String separator)
	{
		this.separator = separator;
	}

	/**
	 * Splits the {@code pair} at the first occurrence of {@code separator} and
	 * returns an array with a length of 2 with the key at position 0 and the
	 * value at position 1
	 * 
	 * @param pair
	 * @return
	 * 
	 * @throws IllegalArgumentException
	 *             If input is no valid kv pair
	 */
	public String[] getKV(String pair)
	{
		int pos = pair.indexOf(this.separator);
		if(pos < 1 || pos > pair.length() - 2)
			throw new IllegalArgumentException("Input is no kv pair");
		String[] kvpair = new String[2];
		kvpair[0] = pair.substring(0, pos);
		kvpair[1] = pair.substring(pos + 1);
		return kvpair;
	}
}
