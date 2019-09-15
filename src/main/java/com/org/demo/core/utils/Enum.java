package com.org.demo.core.utils;

public enum Enum {
	ENUM;
	public enum MemberTypeClassify {
		ENUM;
		public enum Type {
			Platinum("Platinum", "Platinum"),
			Gold("Gold", "Gold"),
			Silver("Silver", "Silver");
			
			private String key;

			private String value;

			Type(final String key, final String value) {
				this.key = key;
				this.value = value;
			}

			public String getKey() {
				return this.key;
			}

			public String getValue() {
				return this.value;
			}
		}
	}
	public enum MemberTypeClassifyCondition {
		ENUM;
		public enum Condition {
			Condition1("Condition1", "50000"),
			Condition2("Condition2", "30000"),
			Condition3("Condition3", "15000");
			
			private String key;

			private String value;

			Condition(final String key, final String value) {
				this.key = key;
				this.value = value;
			}

			public String getKey() {
				return this.key;
			}

			public String getValue() {
				return this.value;
			}
		}
	}
	public enum DemoResponse {
		ENUM;
		public enum responseCode {
			SUCCESS("00000", "Success"),
			FAIL_CODE_00001("00001", "Member Type Classify Error"),
			FAIL_CODE_00002("00002", "Data Not Found");
			
			private String key;

			private String value;

			responseCode(final String key, final String value) {
				this.key = key;
				this.value = value;
			}

			public String getKey() {
				return this.key;
			}

			public String getValue() {
				return this.value;
			}
		}
	}
}
