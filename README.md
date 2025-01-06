Ski Area Management System
==========================

This project is a Ski Area Management System designed to manage ski lifts and ski runs in a ski resort.
Originally created for a university project, it has been improved for broader use. This project was initially developed in GitLab and is now being migrated to GitHub.

## Features

- **Lift Types Management**: Define and manage different types of ski lifts.
- **Lifts Management**: Create and manage ski lifts.
- **Ski Slopes Management**: Describe and manage ski runs.
- **Parking Management**: Manage car parking and associate lifts with parking.
- **File Input**: Read lift types and lifts from a text file.

## Classes and Packages

Classes are located in the `it.polito.ski` package; the main class is `SkiArea`. The `TestExample` class in the `example` package shows usage examples for the main methods and examples of the requested checks.

## Requirements

### R1 - Lift Types

- **Constructor**: Instantiate `SkiArea` with the name of the resort.
- **Methods**:
  - `liftType(code, category, seats)`: Define a new lift type.
  - `getCategory(type)`: Get the category of a lift type.
  - `getCapacity(type)`: Get the number of seats of a lift type.
  - `types()`: Get a list of all defined lift types.

### R2 - Lifts

- **Methods**:
  - `createLift(name, type)`: Define a new lift.
  - `getType(lift)`: Get the type of a lift.
  - `getLifts()`: Get a collection of lifts sorted by name.

### R3 - Ski Slopes

- **Methods**:
  - `createSlope(name, difficulty, lift)`: Describe a new ski run.
  - `getDifficulty(slope)`: Get the difficulty of a ski run.
  - `getStartLift(slope)`: Get the starting lift of a ski run.
  - `getSlopes()`: Get a collection of all ski runs.
  - `getSlopesFrom(lift)`: Get a list of all ski slopes starting from a lift.

### R4 - Parking

- **Methods**:
  - `createParking(name, slots)`: Describe a car parking.
  - `getParkingSlots(parking)`: Get the number of slots in a parking.
  - `liftServedByParking(lift, parking)`: Indicate that a lift departs from a parking.
  - `servedLifts(parking)`: Get a collection of all lifts served by a parking.
  - `isParkingProportionate(parking)`: Check if the parking size is proportional to the capacity of the lifts.

### R5 - Input from File

- **Method**:
  - `readLifts(file)`: Read the description of lift types and lifts from a text file.

## Example

Example of input file format:

```
T ; S4P; seggiovia; 4
T;S;skilift;1
L;Fraiteve;S4P
L;Baby;S
```

The method `readLifts()` propagates possible IO exceptions and skips lines not complying with the format, continuing to read the following lines.

## Copyright

The base code for this project was developed as part of a university course at Politecnico di Torino.


