# Genetic Algorithm

The Genetic Algorithm Research Project is a Java-based application that simulates evolutionary processes to solve optimization problems. It uses genetic algorithms to explore solutions by generating populations, selecting the fittest candidates, and applying genetic operations such as mutation and crossover.

---

## Features

- **Chromosome Representation**: 
  - Encodes solutions as binary chromosomes (arrays of 0s and 1s).
  - Supports mutation and cloning for evolutionary purposes.

- **Population Simulation**:
  - Manages populations and generations to track evolution over time.
  - Implements fitness-based sorting and selection algorithms.

- **GUI Components**:
  - **Chromosome Viewer**: Visual representation of chromosomes as grids.
  - **Population Viewer**: Graphs fitness trends across generations.

- **Fitness Functions**:
  - Includes predefined fitness evaluation methods like "smiley face" and max-fit tests.

- **Selection Strategies**:
  - Supports various selection mechanisms, such as:
    - Truncation
    - Roulette
    - Rank-based
    - Bogo Selection.

- **File Operations**:
  - Loads chromosomes from files and saves results for further analysis.

- **Graphical Interface**:
  - Provides interactive controls for configuring mutation rates, population sizes, and generations.

---

## Usage

1. **Initialize Population**:
   - Randomly generate chromosomes to create an initial population.

2. **Evolution Process**:
   - Apply fitness functions to evaluate chromosomes.
   - Select parents using various selection methods.
   - Perform crossover and mutation to generate the next generation.

3. **Visualize Progress**:
   - Use the Population Viewer to observe fitness trends and the Chromosome Viewer to examine individual solutions.

4. **File Handling**:
   - Import and export chromosomes using the File Loader to persist data across sessions.

---

## Highlights

- Interactive simulation with customizable parameters (mutation rate, population size, etc.).
- Engaging visual representation of evolutionary progress.
- Multiple fitness and selection methods for diverse experimentation.

---

## Future Enhancements

- Implement more complex crossover methods.
- Add support for dynamic fitness functions.
- Expand visualization options for deeper insights into evolutionary trends.
