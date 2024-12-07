import google.generativeai as genai
import sys

API_KEY = 'AIzaSyAj10AwnsfhE6nRPteWWCY-_8V4M4YKFcs'
genai.configure(api_key=API_KEY)
model = genai.GenerativeModel("gemini-1.5-flash")

question = sys.argv[1]

with open('file.txt', 'w') as f:
    f.write(model.generate_content(question).text)

print(model.generate_content("Hi").text)
