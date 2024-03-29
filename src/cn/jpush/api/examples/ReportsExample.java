package cn.jpush.api.examples;

import org.apache.log4j.Logger;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.TimeUnit;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.report.MessagesResult;
import cn.jpush.api.report.ReceivedsResult;
import cn.jpush.api.report.UsersResult;

public class ReportsExample {
	protected static final Logger LOG = Logger.getLogger(ReportsExample.class);

	// demo App defined in resources/jpush-api.conf
	private static final String appKey = Parameter.appKey;
	private static final String masterSecret = Parameter.masterSecret;

	public static void main(String[] args) {
		testGetReport();
		testGetMessages();
		testGetUsers();
	}

	public static void testGetReport() {
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		try {
			ReceivedsResult result = jpushClient.getReportReceiveds("1942377665");
			LOG.debug("Got result - " + result);

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	public static void testGetUsers() {
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		try {
			UsersResult result = jpushClient.getReportUsers(TimeUnit.DAY, "2014-06-10", 3);
			LOG.debug("Got result - " + result);

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	public static void testGetMessages() {
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		try {
			MessagesResult result = jpushClient.getReportMessages("269978303");
			LOG.debug("Got result - " + result);

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

}
