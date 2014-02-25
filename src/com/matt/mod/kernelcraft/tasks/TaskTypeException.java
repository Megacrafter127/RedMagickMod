package com.matt.mod.kernelcraft.tasks;

public class TaskTypeException extends RuntimeException {

	public TaskTypeException() {}

	public TaskTypeException(String message) {
		super(message);
	}

	public TaskTypeException(Throwable cause) {
		super(cause);
	}

	public TaskTypeException(String message, Throwable cause) {
		super(message, cause);
	}
}
