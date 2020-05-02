package com.atomosphere.test.logging;

public class SimpleLogging {
	public static SimpleLogging of() {
		Throwable t = new Throwable();
		StackTraceElement[] stackTrace = t.getStackTrace();
		SimpleLogging simpleLogging = new SimpleLogging();
		if (stackTrace.length > 1) {
			simpleLogging.loggingGroup = stackTrace[1].getClassName();
		}
		return simpleLogging;
	}
	/*
	 * 
		System.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
		System.setProperty("org.slf4j.simpleLogger.dateTimeFormat", "yyyy-MM-dd HH:mm:ss:SSS");
		System.setProperty("org.slf4j.simpleLogger.showThreadName", "true");
		System.setProperty("org.slf4j.simpleLogger.showShortLogName", "true");
		System.setProperty("org.slf4j.simpleLogger.log." + ColferFileWriterTest.class.getPackage().getName(), "DEBUG");
	 */

	private SimpleLogging() {
	}

	private boolean showDateTime = false;
	private String dateTimeFormat = null;
	private boolean showThreadName = false;
	private boolean showShortLogName = false;
	private String loggingGroup = null;
	private String loggingGroupLogLevel = null;
	private String defalutLogLevel = null;
	private boolean showLogName = true;
	private boolean levelInBrackets = false;

	public SimpleLogging showDateTime() {
		this.showDateTime = true;
		return this;
	}

	public SimpleLogging dateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
		return this;
	}

	public SimpleLogging showThreadName() {
		this.showThreadName = true;
		return this;
	}

	public SimpleLogging showShortLogName() {
		this.showShortLogName = true;
		return this;
	}

	public SimpleLogging loggingGroup(String loggingGroup) {
		this.loggingGroup = loggingGroup;
		return this;
	}

	public SimpleLogging loggingGroupLogLevel(String loggingGroupLogLevel) {
		this.loggingGroupLogLevel = loggingGroupLogLevel;
		return this;
	}

	public SimpleLogging defalutLogLevel(String defalutLogLevel) {
		this.defalutLogLevel = defalutLogLevel;
		return this;
	}

	public SimpleLogging notShowLogName() {
		this.showLogName = false;
		return this;
	}

	public SimpleLogging levelInBrackets() {
		this.levelInBrackets = true;
		return this;
	}

	public void initialize() {
		if (showDateTime) {
			System.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
		}
		if (dateTimeFormat != null) {
			System.setProperty("org.slf4j.simpleLogger.dateTimeFormat", dateTimeFormat);
		}
		if (showThreadName) {
			System.setProperty("org.slf4j.simpleLogger.showThreadName", "true");
		}
		if (showShortLogName) {
			System.setProperty("org.slf4j.simpleLogger.showShortLogName", "true");
		}
		if (!showLogName) {
			System.setProperty("org.slf4j.simpleLogger.showLogName", "false");
		}
		if (levelInBrackets) {
			System.setProperty("org.slf4j.simpleLogger.levelInBrackets", "true");
		}
		if (loggingGroupLogLevel != null && loggingGroup != null) {
			System.setProperty("org.slf4j.simpleLogger.log." + loggingGroup, loggingGroupLogLevel);
		} else if (defalutLogLevel != null) {
			System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", defalutLogLevel);
		} else {
			throw new RuntimeException("log level is required.");
		}
	}
}
