package de.mvcturbine.util.config;

public class KVPairParser
{
	private final String seperator;

	public KVPairParser(String seperator)
	{
		this.seperator = seperator;
	}

	public String[] getKV(String pair)
	{
		int pos = pair.indexOf(this.seperator);
		if(pos < 1 || pos > pair.length() - 2)
			throw new IllegalArgumentException("Input is no kv pair");
		String[] kvpair = new String[2];
		kvpair[0] = pair.substring(0, pos);
		kvpair[1] = pair.substring(pos + 1);
		return kvpair;
	}
}
