package it.polito.ski;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SkiArea {
	
	String resortName;
	TreeMap<String, Lifts> liftsMap = new TreeMap<>();
	TreeMap<String, String> ourLifts = new TreeMap<>();
	TreeMap<String, Slope> slopesMap = new TreeMap<>();
	TreeMap<String, Parking> parkingsMap = new TreeMap<>();
	
	/**
	 * Creates a new ski area
	 * @param name name of the new ski area
	 */
	public SkiArea(String name) {
		resortName=name;
    }

	/**
	 * Retrieves the name of the ski area
	 * @return name
	 */
	public String getName() { 
		return resortName;
		}
	

    /**
     * define a new lift type providing the code, the category (Cable Cabin, Chair, Ski-lift)
     * and the capacity (number of skiers carried) of a single unit
     * 
     * @param code		name of the new type
     * @param category	category of the lift
     * @param capacity	number of skiers per unit
     * @throws InvalidLiftException in case of duplicate code or if the capacity is <= 0
     */
    public void liftType(String code, String category, int capacity) throws InvalidLiftException {
    	if(liftsMap.containsKey(code)) {throw new InvalidLiftException("dup code");}
    	Lifts temp=new Lifts(code, category, capacity);
    	liftsMap.put(code, temp);
    	
    }
    
    /**
     * retrieves the category of a given lift type code
     * @param typeCode lift type code
     * @return the category of the type
     * @throws InvalidLiftException if the code has not been defined
     */
    public String getCategory(String typeCode) throws InvalidLiftException {
    	if(!liftsMap.containsKey(typeCode)) {throw new InvalidLiftException("not found");}
		return liftsMap.get(typeCode).getCategory();
    }

    /**
     * retrieves the capacity of a given lift type code
     * @param typeCode lift type code
     * @return the capacity of the type
     * @throws InvalidLiftException if the code has not been defined
     */
    public int getCapacity(String typeCode) throws InvalidLiftException {
    	if(!liftsMap.containsKey(typeCode)) {throw new InvalidLiftException("not found");}
    	return liftsMap.get(typeCode).getSeatsNum();
    }


    /**
     * retrieves the list of lift types
     * @return the list of codes
     */
	public Collection<String> types() {
		return liftsMap.keySet();
	}
	
	/**
	 * Creates new lift with given name and type
	 * 
	 * @param name		name of the new lift
	 * @param typeCode	type of the lift
	 * @throws InvalidLiftException in case the lift type is not defined
	 */
    public void createLift(String name, String typeCode) throws InvalidLiftException{
    	if(!liftsMap.containsKey(typeCode)) {throw new InvalidLiftException("not found");}
    	ourLifts.put(name, typeCode);
    }
    
	/**
	 * Retrieves the type of the given lift
	 * @param lift 	name of the lift
	 * @return type of the lift
	 */
	public String getType(String lift) {
		return ourLifts.get(lift);
	}

	/**
	 * retrieves the list of lifts defined in the ski area
	 * @return the list of names sorted alphabetically
	 */
	public List<String> getLifts(){
		return ourLifts.keySet().stream().sorted().collect(Collectors.toList());
    }

	/**
	 * create a new slope with a given name, difficulty and a starting lift
	 * @param name			name of the slope
	 * @param difficulty	difficulty
	 * @param lift			the starting lift for the slope
	 * @throws InvalidLiftException in case the lift has not been defined
	 */
    public void createSlope(String name, String difficulty, String lift) throws InvalidLiftException {
    	if(!ourLifts.containsKey(lift)) {throw new InvalidLiftException("not found");}
    	Slope temp=new Slope(name, difficulty, lift);
    	slopesMap.put(name, temp);
    }
    
    /**
     * retrieves the name of the slope
     * @param slopeName name of the slope
     * @return difficulty
     */
	public String getDifficulty(String slopeName) {
		return slopesMap.get(slopeName).getDifficulty();
	}

	/**
	 * retrieves the start lift
	 * @param slopeName name of the slope
	 * @return starting lift
	 */
	public String getStartLift(String slopeName) {
		return slopesMap.get(slopeName).getLiftName();
	}

	/**
	 * retrieves the list of defined slopes
	 * 
	 * @return list of slopes
	 */
    public Collection<String> getSlopes(){
		return slopesMap.keySet();
    }

    /**
     * Retrieves the list of slopes starting from a given lift
     * 
     * @param lift the starting lift
     * @return the list of slopes
     */
    public Collection<String> getSlopesFrom(String lift){
		return slopesMap.values().stream().filter(x->x.getLiftName().equals(lift))
				.map(x->x.getRunName()).collect(Collectors.toList());
    }

    /**
     * Create a new parking with a given number of slots
     * @param name 	new parking name
     * @param slots	slots available in the parking
     */
    public void createParking(String name, int slots){
    	Parking temp=new Parking(name, slots);
    	parkingsMap.put(name, temp);
    	
    }

    /**
     * Retrieves the number of parking slots available in a given parking
     * @param parking	parking name
     * @return number of slots
     */
	public int getParkingSlots(String parking) {
		return parkingsMap.get(parking).getNumberOfSlots();
	}

	/**
	 * Define a lift as served by a given parking
	 * @param lift		lift name
	 * @param parking	parking name
	 */
	public void liftServedByParking(String lift, String parking) {
		parkingsMap.get(parking).addNewLifts(lift);
	}

	
	/**
	 * Retrieves the list of lifts served by a parking.
	 * @param parking	parking name
	 * @return the list of lifts
	 */
	public Collection<String> servedLifts(String parking) {
		return parkingsMap.get(parking).getServedLifts();
	}

	/**
	 * Checks whether the parking is proportional to the capacity of the lift it is serving.
	 * A parking is considered proportionate if its size divided by the sum of the capacity of the lifts 
	 * served by the parking is less than 30.
	 * 
	 * @param parkingName name of the parking to check
	 * @return true if the parking is proportionate
	 */
	public boolean isParkingProportionate(String parkingName) {
		int sum=0;	
		
		for(String liftname:servedLifts(parkingName)) {
			sum+=liftsMap.get(ourLifts.get(liftname)).getSeatsNum();
		}
		
		return (parkingsMap.get(parkingName).getNumberOfSlots()/sum)<30;
	}

	/**
	 * reads the description of lift types and lift descriptions from a text file. 
	 * The contains a description per line. 
	 * Each line starts with a letter indicating the kind of information: "T" stands for Lift Type, 
	 * while "L" stands for Lift.
	 * A lift type is described by code, category and seat number. 
	 * A lift is described by the name and the lift type.
	 * Different data on a line are separated by ";" and possible spaces surrounding the separator are ignored.
	 * If a line contains the wrong number of information it should be skipped and
	 * the method should continue reading the following lines. 
	 * 
	 * @param path 	the path of the file
	 * @throws IOException	in case IO error
	 * @throws InvalidLiftException in case of duplicate type or non-existent lift type
	 */
    public void readLifts(String path) throws IOException, InvalidLiftException {
    		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

				 String line;
				 String[] tempArr; 
				 while ((line=bufferedReader.readLine())!=null) {
					 tempArr=line.split(";");
					 
					 if(tempArr.length==4) {
						 //System.out.println(line+"--->"+tempArr[1].strip()+"|"+tempArr[2].strip()+"|"+Integer.valueOf(tempArr[3].strip()));
						 liftType(tempArr[1].strip(), tempArr[2].strip(),Integer.valueOf(tempArr[3].strip()));
					 }
					 
					 if(tempArr.length==3) {
						 //System.err.println(line+"--->"+tempArr[1].strip()+"|"+ tempArr[2].strip());
						 createLift(tempArr[1].strip(), tempArr[2].strip());
						 
					 }
					 
				 }

    			
    			
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

}
