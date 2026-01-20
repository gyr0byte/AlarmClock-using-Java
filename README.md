# Alarm Clock (Java)

Simple console alarm clock built with `java.time.LocalTime`. Enter a target time in `HH:MM:SS` and the app prints the current time every second until the alarm time is reached.

## Features

- Lightweight: two small classes with no external dependencies
- Uses `LocalTime` for parsing/validation of `HH:MM:SS`
- Runs the alarm checker on a dedicated thread

## Requirements

- Java 8 or newer

## Quick start

From the project root:

```bash
javac Main.java AlarmClock.java
java Main
```

## Usage

1. Run `java Main`.
2. When prompted, enter an alarm time in `HH:MM:SS` (24-hour).
3. The program confirms the alarm time and starts printing the current time once per second until that time is reached.

### Example session

```
Enter an alarm time (HH:MM:SS): 23:30:00
Alarm set for: 23:30
2026-01-20T23:29:01.234567800
2026-01-20T23:29:02.235123400
...
```

## Notes and tips

- The loop only runs while `LocalTime.now().isBefore(alarmTime)`. If you enter a time that has already passed (or exactly the current second), nothing prints because the condition is immediately false. Enter a future time to see the per-second output.
- To support rolling the alarm to “tomorrow” automatically, you can adjust `alarmTime` in `Main` by adding a day when it is before `LocalTime.now()`.

## Project structure

- Main entry point: [Main.java](Main.java)
- Alarm worker thread: [AlarmClock.java](AlarmClock.java)
