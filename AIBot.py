# Working
# Execute by writing a prompt in file.txt. Once compiled, it will write the responce into the file.

import google.generativeai as genai
# import google
import sys

API_KEY = 'ENTER_API_KEY' #Change this
genai.configure(api_key=API_KEY)
model = genai.GenerativeModel("gemini-1.5-flash")

# Read the file
with open('file.txt', 'r') as f:
    question = f.read() 

# Uncomment this if using using input directly. Run by executing the file + " " + prompt
# question = sys.argv[1] 
    
# print(question)
with open('file.txt', 'w') as f:
    f.write(model.generate_content(question).text)

# Method for use
def getAns(question):
    return model.generate_content(question).text

print("Schedule generated! ") #Comment this out if facing errors
#print(model.generate_content("Hi").text)
