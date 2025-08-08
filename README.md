# Quiz Application - Android

A simple quiz application built for Android using Kotlin. The app tests users' knowledge of country flags through a series of multiple-choice questions.

## Features

- User authentication with username
- Multiple-choice questions with flag images
- Progress tracking during the quiz
- Score calculation and result display
- Visual feedback for correct/incorrect answers
- Trophy display for perfect scores

## Screens

1. **Main Activity**
   - Username input
   - Start quiz button

2. **Questions Activity**
   - Displays flag images and multiple-choice options
   - Shows progress through the quiz
   - Provides visual feedback for selected answers

3. **Result Activity**
   - Displays username and score
   - Shows number of correct and incorrect answers
   - Displays trophy for perfect scores

## Technical Details

- **Language**: Kotlin
- **Architecture**: Single Activity for each screen
- **Data**: Questions stored in a companion object
- **UI**: ConstraintLayout with Material Design components
- **Features**:
  - Intent-based navigation
  - Custom drawables for options and backgrounds
  - Dynamic score calculation

## Question Structure

Each question contains:
- Question text
- Flag image resource
- Four options
- Correct answer index

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Build and run on an emulator or physical device

## Dependencies

- AndroidX libraries
- Material Design components

## Future Improvements

- Add more question categories
- Implement difficulty levels
- Add timer functionality
- Include sound effects
- Implement database for questions
- Add user score history

