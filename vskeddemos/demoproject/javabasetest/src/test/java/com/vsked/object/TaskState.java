package com.vsked.object;

public class TaskState {
	
	TaskStateEnum state;

	public TaskState(Byte taskStateinput) {
        if(taskStateinput==null){
            throw new IllegalArgumentException("任务状态不能为空！");
        }
		// 验证任务状态规则
		this.state = TaskState.numberToState(taskStateinput);
	}

	public TaskStateEnum getState() {
		return state;
	}

	// 任务状态
	public static TaskStateEnum numberToState(Byte b) {
		switch (b) {
		case 0:
			return TaskStateEnum.created;
		case 1:
			return TaskStateEnum.confirmOn;
		case 2:
			return TaskStateEnum.completed;
		case 3:
			return TaskStateEnum.invalid;
		case 4:
			return TaskStateEnum.suspend;
		case 5:
			return TaskStateEnum.proceed;
		case 6:
			return TaskStateEnum.delay;
		default:
			throw new IllegalArgumentException("任务状态获取异常！");
		}
	}

	public static Byte StateToNumber(TaskStateEnum ts) {
		switch (ts) {
		case created:
			return new Byte("0");
		case confirmOn:
			return new Byte("1");
		case completed:
			return new Byte("2");
		case invalid:
			return new Byte("3");
		case suspend:
			return new Byte("4");
		case proceed:
			return new Byte("5");
		case delay:
			return new Byte("6");
		default:
			throw new IllegalArgumentException("任务状态存储异常");
		}
	}

	public String toString() {
		return "" + state;
	}
}
