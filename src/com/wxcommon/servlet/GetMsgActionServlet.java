package com.wxcommon.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxcommon.conf.Constants;
import com.wxcommon.service.RespMsgService;

public class GetMsgActionServlet extends HttpServlet{
	private static final long serialVersionUID = 771353098285046467L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		sortCheck(req, resp, Constants.DEVELOP_CHECK); 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		if(sortCheck(request, response, Constants.MSG_CHECK)) {
			String replayMsg = new RespMsgService().getRespMsg(request);
			
			outStream(response, replayMsg);
		}
	}

	/**
	 * 微信请求验证
	 */
	private boolean sortCheck(HttpServletRequest request, HttpServletResponse response, int tag) throws IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostring = request.getParameter("echostr");
		String token = "jcxts20131113";
		
		String[] strSet = new String[]{token, timestamp, nonce};
		java.util.Arrays.sort(strSet);
		
		String total = "";
		for(String string : strSet) {
			total = total + string;
		}
		
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			sha1.update(total.getBytes());
			
			byte[] codedBytes = sha1.digest();
			String codedString = new BigInteger(1, codedBytes).toString(16);
			
			if(codedString.equals(signature)) {
				if(tag == Constants.DEVELOP_CHECK) {
					outStream(response, echostring);
					return true;
				}else if (tag == Constants.MSG_CHECK) {
					return true;
				}
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 服务端response输出流
	 */
	private void outStream(HttpServletResponse response, String replay) {
		try {
			OutputStream outStream = response.getOutputStream();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outStream));
			bufferedWriter.write(replay);
			bufferedWriter.flush();
			bufferedWriter.close();
			
			System.out.println("消息回复成功");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("消息回复失败，出现异常");
		}
	}

}
