package com.example.hyde.spreadsheet;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("user")
	public List<UserItem> user;
}