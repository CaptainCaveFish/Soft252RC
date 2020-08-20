/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author dillonlaskey
 */
public final class Data {
    
    int freeInt = 0;
    String rawLine;
    String[] line;
    
    //Data file
    private File dataFile = new File("dataFile.txt");
    
    //Arrays for storing data
    private User[] userData;
    private Request[] requestData;
    private Rating[] ratingData;
    private Appointment[] appointmentData;
    private History[] patientData;
    private Prescription[] prescriptionData;
    private Medicine[] medicineData;
    private Feedback[] feedbackData;
    
    //File reader
    BufferedReader reader;
    
    
    Data(){
            try{
                //Instances a file reader
                reader = new BufferedReader(new FileReader(dataFile));
                rawLine = reader.readLine();
                    userData = new User[0];
                    while (rawLine.equals("**Requests**") == false){
                        line = rawLine.split(",");
                        addUser(new User(line[0],line[1],line[2],line[3],line[4],line[5],line[6],line[7]));
                        rawLine = reader.readLine();
                    }
                    rawLine = reader.readLine();
                    requestData = new Request[0];
                    while (rawLine.equals("**Ratings**") == false){
                        line = rawLine.split(",");
                        addRequest(new Request(line[0],line[1],line[2],line[3]));
                        rawLine = reader.readLine();
                    }
                    rawLine = reader.readLine();
                    ratingData = new Rating[0];
                    while (rawLine.equals("**Appointments**") == false){
                        line = rawLine.split(",");
                        addRating(new Rating(line[0],line[1],line[2]));
                        rawLine = reader.readLine();
                    }
                    rawLine = reader.readLine();
                    appointmentData = new Appointment[0];
                    while (rawLine.equals("**History**") == false){
                        line = rawLine.split(",");
                        addAppointment(new Appointment(line[0],line[1],line[2],line[3],line[4],line[5]));
                        rawLine = reader.readLine();
                    }
                    rawLine = reader.readLine();
                    patientData = new History[0];
                    while (rawLine.equals("**Prescriptions**") == false){
                        line = rawLine.split(",");
                        addPatientHistory(new History(line[0],line[1],line[2]));
                        rawLine = reader.readLine();
                    }
                    rawLine = reader.readLine();
                    prescriptionData = new Prescription[0];
                    while (rawLine.equals("**Medicine**") == false){
                        line = rawLine.split(",");
                        addPrescription(new Prescription(line[0],line[1],line[2],line[3],line[4]));
                        rawLine = reader.readLine();
                    }
                    rawLine = reader.readLine();
                    medicineData = new Medicine[0];
                    while (rawLine.equals("**Feedback**") == false){
                        line = rawLine.split(",");
                        addMedStocks(new Medicine(line[0],Integer.parseInt(line[1])));
                        rawLine = reader.readLine();
                    }
                    rawLine = reader.readLine();
                    feedbackData = new Feedback[0];
                    while (rawLine != null){
                        line = rawLine.split(",");
                        addFeedback(new Feedback(line[0],line[1],line[2]));
                        rawLine = reader.readLine();
                    }
                reader.close();
            }
            catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    
    public User[] getUsers(){
        return userData;
    }
    public Request[] getRequests(){
        return requestData;
    }
    public Rating[] getRatings(){
        return ratingData;
    }
    public Appointment[] getAppointments(){
        return appointmentData;
    }
    public History[] getPatientHistory(){
        return patientData;
    }
    public Prescription[] getPrescriptions(){
        return prescriptionData;
    }
    public Medicine[] getMedStocks(){
        return medicineData;
    }
    public Feedback[] getFeedback(){
        return feedbackData;
    }
    
    public void addUser(User user){
        User[] newData = new User[userData.length + 1];
        int index = 0;
        for (User u : userData){
            newData[index] = u;
            index += 1;
        }
        newData[index] = user;
        userData = newData;
    }
    public void addRequest(Request request){
        Request[] newData = new Request[requestData.length + 1];
        int index = 0;
        for (Request r : requestData){
            newData[index] = r;
            index += 1;
        }
        newData[index] = request;
        requestData = newData;
    }
    public void addRating(Rating rating){
        Rating[] newData = new Rating[ratingData.length + 1];
        int index = 0;
        for (Rating r: ratingData){
            newData[index] = r;
            index += 1;
        }
        newData[index] = rating;
        ratingData = newData;
    }
    public void addAppointment(Appointment appointment){
        Appointment[] newData = new Appointment[appointmentData.length + 1];
        int index = 0;
        for (Appointment a : appointmentData){
            newData[index] = a;
            index += 1;
        }
        newData[index] = appointment;
        appointmentData = newData;
    }
    public void addPatientHistory(History history){
        History[] newData = new History[patientData.length + 1];
        int index = 0;
        for (History h:patientData){
            newData[index] = h;
            index += 1;
        }
        newData[index] = history;
        patientData = newData;
    }
    public void addPrescription(Prescription prescription){
        Prescription[] newData = new Prescription[prescriptionData.length + 1];
        int index = 0;
        for (Prescription p : prescriptionData){
            newData[index] = p;
            index += 1;
        }
        newData[index] = prescription;
        prescriptionData = newData;
    }
    public void addMedStocks(Medicine medicine){
        Medicine[] newData = new Medicine[medicineData.length + 1];
        int index = 0;
        for (Medicine m : medicineData){
            newData[index] = m;
            index += 1;
        }
        newData[index] = medicine;
        medicineData = newData;
    }
    public void addFeedback(Feedback feedback){
        Feedback[] newData = new Feedback[feedbackData.length + 1];
        int index = 0;
        for (Feedback f : feedbackData){
            newData[index] = f;
            index += 1;
        }
        newData[index] = feedback;
        feedbackData = newData;
    }
    
    public void removeUser(int target){
        User[] newUserData = new User[userData.length - 1];
        int index = 0;
        for (User u: userData){
            if (u.getID() != target){
                newUserData[index] = u;
                index+=1;
            }
        }
        userData = newUserData;
    }
    public void removeRequest(int target){
        int index = 0;
        Request[] newRequestData = new Request[requestData.length - 1];
        for(Request r : requestData){
            if (r.getRequestID() != target){
                newRequestData[index] = r;
                index += 1;
            }
        }
        requestData = newRequestData;
    }
    public void removePrescription(int target){
        int index = 0;
        Prescription[] newPrescriptionData = new Prescription[prescriptionData.length - 1];
        for(Prescription p : prescriptionData){
            if (p.getID() != target){
                newPrescriptionData[index] = p;
                index += 1;
            }
            
        }
        prescriptionData = newPrescriptionData;
    }
    
    public User searchUsers(int target){
        User output = null;
        for (User u : userData){
            if (u.getID()== target){
                output = u;
            } 
        }
        return output;
    }
    public User searchUsers(String firstname, String lastname){
        User output = null;
        for (User u : userData){
            if (u.getFirstName().equals(firstname) && u.getLastName().equals(lastname)){
                output = u;
            } 
        }
        return output;
    }
    
    public void lowerMeds(String med,int amount){
        for (Medicine m : medicineData){
            if(m.getMed().equals(med)){
                m.setSupply(m.getSupply() - amount);
            }
        }
    }
    
    public void raiseMeds(String med,int amount){
        for (Medicine m : medicineData){
            if(m.getMed().equals(med)){
                m.setSupply(m.getSupply() + amount);
            }
        }
    }
    
    public void close(){
        try{
            dataFile.delete();
            dataFile.createNewFile();
            FileWriter w = new FileWriter(dataFile,true);
            for(User u: userData){
                String uLine = u.getFirstName() + "," + u.getLastName() + "," + u.getAdress() + "," + Integer.toString(u.getAge()) + "," + u.getGender() + "," + u.getType() + "," + Integer.toString(u.getID()) + "," + u.getPassWord() + "\n";
                w.append(uLine);
            }
            w.write("**Requests**\n");
            for(Request r: requestData){
                String rLine = Integer.toString(r.getUserID()) + "," + r.getType() + "," + r.getDetails() + "," + Integer.toString(r.getRequestID()) + "\n";
                w.write(rLine);
            }
            w.write("**Ratings**\n");
            for(Rating r: ratingData){
                String rLine = Integer.toString(r.getWriter()) + "," + Integer.toString(r.getSubject()) + "," + r.getComment() + "\n";
                w.write(rLine);
            }
            w.write("**Appointments**\n");
            for(Appointment a: appointmentData){
                String timeString = "";
                for(int t : a.getTime()){
                    timeString.concat(Integer.toString(t));
                    timeString.concat(",");
                }
                String aLine = timeString + Integer.toString(a.getPatient()) + "," + Integer.toString(a.getDoctor()) + "\n";
                w.write(aLine);
            }
            w.write("**History**\n");
            for(History h: patientData){
                String hLine = Integer.toString(h.getPatientID()) + "," + Integer.toString(h.getPatientID()) + "," + h.getNote() + "\n";
                w.write(hLine);
            }
            w.write("**Prescriptions**\n");
            for(Prescription p: prescriptionData){
                String pLine = Integer.toString(p.getID()) + "," + Integer.toString(p.getPatient()) + "," + p.getMedicine() + "," + Integer.toString(p.getDose())  + "\n";
                w.write(pLine);
            }
            w.write("**Medicine**\n");
            for(Medicine m: medicineData){
                String mLine = m.getMed() + "," + Integer.toString(m.getSupply()) + "\n";
                w.write(mLine);
            }
            w.write("**Feedback**\n");
            for(Feedback f: feedbackData){
                String fLine = Integer.toString(f.getAdmin()) + "," + Integer.toString(f.getDoctor()) + "," + f.getNote() + "\n";
                w.write(fLine);
            }
            w.close();
        }
        catch(IOException e){
            
        }
    }
}
