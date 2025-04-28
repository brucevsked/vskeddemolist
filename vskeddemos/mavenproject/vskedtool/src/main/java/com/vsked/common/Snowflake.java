package com.vsked.common;

import java.util.concurrent.atomic.AtomicLong;

public class Snowflake {
	private static final long EPOCH = 1609459200000L; // 自定义起始时间戳 (2021-01-01)
	private static final long WORKER_ID_BITS = 5L;
	private static final long DATA_CENTER_ID_BITS = 5L;
	private static final long SEQUENCE_BITS = 12L;

	private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
	private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS);

	private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
	private static final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
	private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS;

	private final long workerId;
	private final long dataCenterId;
	private final AtomicLong sequence = new AtomicLong(0L);
	private volatile long lastTimestamp = -1L;

	public Snowflake(long workerId, long dataCenterId) {
		if (workerId > MAX_WORKER_ID || workerId < 0) {
			throw new IllegalArgumentException("Worker ID can't be greater than " + MAX_WORKER_ID + " or less than 0");
		}
		if (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0) {
			throw new IllegalArgumentException("Data Center ID can't be greater than " + MAX_DATA_CENTER_ID + " or less than 0");
		}
		this.workerId = workerId;
		this.dataCenterId = dataCenterId;
	}

	public synchronized long nextId() {
		long timestamp = System.currentTimeMillis();

		if (timestamp < lastTimestamp) {
			throw new RuntimeException("Clock moved backwards. Refusing to generate id");
		}

		if (lastTimestamp == timestamp) {
			sequence.set((sequence.get() + 1) & ~(-1L << SEQUENCE_BITS));
			if (sequence.get() == 0) {
				timestamp = waitNextMillis(lastTimestamp);
			}
		} else {
			sequence.set(0L);
		}

		lastTimestamp = timestamp;

		return ((timestamp - EPOCH) << TIMESTAMP_LEFT_SHIFT) |
				(dataCenterId << DATA_CENTER_ID_SHIFT) |
				(workerId << WORKER_ID_SHIFT) |
				sequence.get();
	}

	private long waitNextMillis(long lastTimestamp) {
		long timestamp = System.currentTimeMillis();
		while (timestamp <= lastTimestamp) {
			timestamp = System.currentTimeMillis();
		}
		return timestamp;
	}

}