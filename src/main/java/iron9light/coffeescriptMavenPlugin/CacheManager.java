package iron9light.coffeescriptMavenPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.maven.plugin.MojoExecutionException;

public class CacheManager {
	
	Boolean isCacheEnabled = false;
	File cacheDirectory = null;
	
	public CacheManager( File cd ){
		if( cd != null ){
			this.isCacheEnabled = true;
			this.cacheDirectory = cd;
		}
	}
	
	public String getDigest( File file ) throws IOException{
		String md5 = null;
		try {
			md5 = DigestUtils.md5Hex( new FileInputStream( file ) );
		} catch (IOException e) {
			throw new IOException("Cannot create digest from file " + file);
		}
		return md5;
	}
	
}
