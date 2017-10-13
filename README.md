# calculator
A simple android calculator app.

<img src="http://i.imgur.com/SzKoNcwm.png">  <img src="http://i.imgur.com/C0YVtLSm.png">
## Structure
The app is using a very basic MVP setup, the presenter handles changes to the current calculation and returns the relevant responses to the view.

## Calculations
Calculations are handled using some logic from http://stackoverflow.com/a/26227947

## Testing
The presenter is unit tested using Mockito to help Mock some classes.
