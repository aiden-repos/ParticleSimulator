# Particle Simulator

## Description

Particle Simulator is a Java-based Swing application that simulates the interactions of subatomic particles—including electrons, protons, neutrons, positrons, antiprotons, and muons.

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Build Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/aiden-repos/ParticleSimulator.git
   cd ParticleSimulator
   ```
2. Compile the source code:
   ```bash
   mkdir bin
   javac -d bin \
     src/MainWindow.java \
     src/Simulator.java \
     src/Particles/*.java
   ```

OR

1. Use the JAR file included in this repository.

OR

1. Download the JAR [here](ParticleSim.jar).

## Usage

### Running the Simulator
- From compiled classes:
  ```bash
  java -cp bin MainWindow
  ```
- From JAR:
  ```bash
  java -jar ParticleSimulator.jar
  ```

Use the GUI controls at the bottom of the window to add particles by type. The simulation displays particle motion, collisions, and annihilation events in real time.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
