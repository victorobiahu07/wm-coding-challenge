package com.workmarket.coding.challenge.util;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeoCoding {
	String status;
	
	@JsonProperty(value="outputs")
	
	GeoCodingOutput[] geoCodingOutputs;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GeoCodingOutput[] getgeoCodingOutputs() {
		return geoCodingOutputs;
	}

	public void setgeoCodingOutputs(GeoCodingOutput[] geoCodingOutputs) {
		this.geoCodingOutputs = geoCodingOutputs;
	}

	@Override
	public String toString() {
		return "GeoCoding [status=" + status + ", geoCodingOutputs=" + Arrays.toString(geoCodingOutputs) + "]";
	}
}