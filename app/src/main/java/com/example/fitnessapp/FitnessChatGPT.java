package com.example.fitnessapp;

import android.os.AsyncTask;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class FitnessChatGPT {

	public FitnessChatGPT(String x) {
		new ChatGPTAsyncTask().execute(x);
		System.out.println("succes");
	}

	private static class ChatGPTAsyncTask extends AsyncTask<String, Void, String> {

		@Nullable
		@Override
		protected String doInBackground(String... params) {
			System.out.println("class reach");
			try {
				String workout2 = params[0];
				String url = "https://api.openai.com/v1/chat/completions";
				HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Authorization", "Bearer " + "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");

				String model = "gpt-3.5-turbo";

				String prompt = "[{\"role\": \"user\", \"content\": \"" + workout2 + "\"}]";

				int maxTokens = 100;

				con.setDoOutput(true);
				String body = "{\"model\": \"" + model + "\", \"messages\": " + prompt + ", \"max_tokens\": " + maxTokens + "}";

				OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
				writer.write(body);
				writer.flush();

				// Read the response
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				return response.toString();
			} catch (Exception e) {
				e.printStackTrace();
				return null; // Handle errors appropriately
			}
		}

		@Override
		protected void onPostExecute(String response) {
			if (response != null) {
				System.out.println(response);
				WeeklyPlan.Response = response;
				// You can update the UI or perform any other necessary actions here
			} else {
				// Handle the case where the network request failed
			}
		}
	}
}
