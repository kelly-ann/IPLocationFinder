package org.kelly_ann;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Please pass in an IP address.");
		}
		else
		{
			// http://www.webservicex.net/geoipservice.asmx?WSDL
			// GeoIPService is in the <wsdl:service> in the wsdl's XML.
			// GeoIPServiceSoap is in the <wsdl:port> within the <wsdl:service> XML tags in the wsdl.
			// GeoIP is the actual IP object with the information about the IP.
			// sample IP's to pass in as an arg:  bbc.com = 70.126.135.19 OR google.com = 74.125.239.142
			String ipAddress = args[0];
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);
			System.out.println(geoIP.getCountryName());
			
		}
	

	}

}
