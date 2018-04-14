package com.custvs.common;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringToolTest {
	
	private static final Logger log=LoggerFactory.getLogger(StringToolTest.class);
	
//	@Test
	public void jsonToMap(){
		String s="{\"errcode\":0,\"errmsg\":\"ok\",\"access_token\":\"cCJtMzaVGkP1T-AmRNTkIYSvg5MaDFWrR2AJfHMjYRfxc-NxVQi4hOYA9tyiVJ-miKQ1xVUE67AoZD0ADkvv-Nw94216CEtk-0oScLWot79W2K-TZwN40QE7MthPzmu2oLC_vQQKnVe0uHiQqEHKcwf4r8-V2UtUOV_VZYgRUd-RmtLyTjD6hgIuPywk8LzG9bny4wsxdrK6C8XX717Nug\",\"expires_in\":7200}";
		try {
			Map<String, Object> m=StringTool.jsonToMap(s);
			log.debug(m+"");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void t1(){
		Map<String, Object> m=new HashMap<String, Object>();
		log.debug("|"+m.get("cc")+"|");
	}

}
