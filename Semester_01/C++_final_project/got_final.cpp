#include <iostream>
#include <fstream>
using namespace std;
int main(){
    cout<< "================================================================================\n";
    cout<<"\033[31mThis text is red.\033[0m\n";
    cout<< "================================================================================\n";

    string name;
    cout << "Enter your Name: ";
    getline(cin,name);

    string questions[10] = {
        "Q1. What does the acronym 'CPU' stand for?",
        "Q2. Which of the following is an example of an input device?",
        "Q3. What does 'URL' stand for?",
        "Q4. Which software is used for creating documents?",
        "Q5. What is the primary function of an operating system?",
        "Q6. Which of these is not a programming language?",
        "Q7. What does 'Wi-Fi' stand for?",
        "Q8. Which of the following is a popular web browser?",
        "Q9. What does the 'cloud' refer to in cloud computing?",
        "Q10. Which of these is an example of a storage device?"
    };

    string options[10][3] = {
        {"1. Central Processing Unit", "2. Computer Personal Unit", "3. Computer Program Unit"},
        {"1. Keyboard", "2. Printer", "3. Monitor"},
        {"1. Uniform Resource Locator", "2. Universal Resource Locator", "3. Uniform Retrieval Locator"},
        {"1. Microsoft Word", "2. Microsoft Excel", "3. Microsoft PowerPoint"},
        {"1. Manage hardware and software resources", "2. Run applications", "3. Provide internet services"},
        {"1. Python", "2. JavaScript", "3. Excel"},
        {"1. Wireless Fidelity", "2. Wide Frequency", "3. Wireless Frequency"},
        {"1. Google Chrome", "2. Safari", "3. Internet Explorer"},
        {"1. Data storage on physical servers", "2. Virtual storage accessed over the internet", "3. A type of data encryption"},
        {"1. Hard Drive", "2. Monitor", "3. CPU"}
    };

    int correctAnswers[10] = {1, 1, 1, 1, 1, 3, 1, 1, 2, 1};

    float score ;
    double answer;

    for(int i = 0; i < 10; i++) {
        cout<<questions[i]<<endl;

        for(int j = 0; j < 3; j++) {
            cout<<options[i][j]<<endl;
        }

        cout<<"Enter your answer (1-3): ";
        cin>>answer;

    if (answer == correctAnswers[i]) {
    score++;
    cout<<"Correct!\n";
    } 
    else if (answer != 1 && answer != 2 && answer != 3) {
    cout<<"You have entered an invalid symbol or number.\n";
    } 
    else 
	{
    score - 1;
    cout<<"Incorrect. The correct answer is " << correctAnswers[i] << endl;
    cout<< "1 marks deducted for incorrect answer.\n";
    }
        cout<<endl;
    }

    double percentage = (score/10.0) * 100;

    cout<<"Your final score out of 10 is : "<<score<<endl;
    cout<<"Your percentage is: " <<percentage<<"%"<<endl;

    ofstream resultFile("result.txt");
    if (resultFile) {
        resultFile<< "Name: "<<name<<endl;
        resultFile<< "Your score out of 10/ " << score << endl;
        resultFile<< "Your percentage is: " << percentage << "%" << endl;
        cout<<"Your results have been saved to the file." << endl;
    } 
	else {
        cout<<"There is an error while saving the file"<<endl;
    }

    return 0;
}