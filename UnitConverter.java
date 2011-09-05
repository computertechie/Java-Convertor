/*
Ean McLaughlin
March 3
UnitConverter.java
This program converts units of measure
*/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class UnitConverter extends Frame implements ActionListener
{
	//class variables
	 double measurement, output;
	 TextField inputField = new TextField(20);
	 TextField outputField = new TextField(20);
	 boolean first = true;
	 Button buttons[] = new Button[12];
	 Panel buttonPanel = new Panel();
	 Panel ioPanel = new Panel();
	 Label inputLabel = new Label("");
	 Label outputLabel = new Label("");
	 Button equalButton = new Button("=");

	 MenuBar mnuBar = new MenuBar();

	Menu mnuFile = new Menu("File");
	MenuItem mnuFileExit = new MenuItem("Exit");

	Menu mnuUnits = new Menu("Units");
	Menu mnuUnitsMetric = new Menu("Metric");
	Menu mnuUnitsUSA =new Menu("U.S.");
	Menu mnuUnitsMetricLength = new Menu("Length");
	MenuItem mnuUnitsMetricLengthMeters = new MenuItem("Meters");
	MenuItem mnuUnitsMetricLengthKilometer = new MenuItem("Kilometers");
	MenuItem mnuUnitsMetricLengthCentimeter = new MenuItem("Centimeters");

	Menu mnuUnitsUSALength = new Menu("Length");
	MenuItem mnuUnitsUSALengthFeet = new MenuItem("Feet");
	MenuItem mnuUnitsUSALengthYards = new MenuItem("Yards");
	MenuItem mnuUnitsUSALengthMile =new MenuItem("Miles");
	MenuItem mnuUnitsUSALengthInch = new MenuItem("Inches");

	Menu mnuUnitsUSAWeight = new Menu("Weight");
	MenuItem mnuUnitsUSAWeightOunces = new MenuItem("Ounces");
	MenuItem mnuUnitsUSAWeightPounds = new MenuItem("Pounds");
	MenuItem mnuUnitsUSAWeightTons = new MenuItem("Tons");

	Menu mnuUnitsMetricWeight = new Menu("Weight");
	MenuItem mnuUnitsMetricWeightGrams = new MenuItem("Grams");
	MenuItem mnuUnitsMetricWeightKilograms = new MenuItem("Kilograms");

	Menu mnuUnitsUSAArea = new Menu("Area");
	MenuItem mnuUnitsUSAAreaFeetSquare = new MenuItem("Square Feet");
	MenuItem mnuUnitsUSAAreaAcre = new MenuItem("Acre");
	MenuItem mnuUnitsUSAAreaSection =new MenuItem("Section");

	Menu mnuUnitsMetricArea = new Menu("Area");
	MenuItem mnuUnitsMetricAreaMeterSquare = new MenuItem("Square Meter");
	MenuItem mnuUnitsMetricAreaKilometerSquare = new MenuItem("Square Kilometer");

	Menu mnuUnitsMetricFluids = new Menu("Fluids");
	MenuItem mnuUnitsMetricFluidsMilliLiter = new MenuItem("MilliLiter");
	MenuItem mnuUnitsMetricFluidsLiter = new MenuItem("Liter");

	Menu mnuUnitsUSAFluids = new Menu("Fluids");
	MenuItem mnuUnitsUSAFluidsOunces = new MenuItem("Ounces");
	MenuItem mnuUnitsUSAFluidsCups = new MenuItem("Cups");
	MenuItem mnuUnitsUSAFluidsPints = new MenuItem("Pints");
	MenuItem mnuUnitsUSAFluidsQuarts = new MenuItem("Quarts");
	MenuItem mnuUnitsUSAFluidsGallon = new MenuItem("Gallon");

	Menu mnuUnitsUSATemp = new Menu("Temperature");
	MenuItem mnuUnitsUSATempFahrenheit = new MenuItem("Fahrenheit");

	Menu mnuUnitsMetricTemp = new Menu("Temperature");
	MenuItem mnuUnitsMetricTempCelsius =new MenuItem("Celsius");
	MenuItem mnuUnitsMetricTempKelvin = new MenuItem("Kelvin");

	Menu mnuUnitsTroy = new Menu("Troy");
	MenuItem mnuUnitsTroyGrain = new MenuItem("Grain");
	MenuItem mnuUnitsTroyOunce = new MenuItem("Ounce");
	MenuItem mnuUnitsTroyPound = new MenuItem("Pound");
	MenuItem mnuUnitsTroyPenny = new MenuItem("Pennyweight");

	public UnitConverter()
	{
		inputField.setEditable(false);
		outputField.setEditable(false);

		setLayout(new BorderLayout());
		add(ioPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(equalButton, BorderLayout.SOUTH);
		buttonPanel.setLayout(new GridLayout(4,4,3,4));
		ioPanel.add(inputLabel);
		ioPanel.add(inputField);
		ioPanel.add(outputLabel);
		ioPanel.add(outputField);

		for(int i = 0; i <=9; i++)
		buttons[i] = new Button(String.valueOf(i));

		for(int i = 7; i<=9; i++)//add 7,8,9
		buttonPanel.add(buttons[i]);

		for(int i = 4; i<=6; i++)
		buttonPanel.add(buttons[i]);//add 4,5,6

		for(int i = 1; i<=3; i++)
		buttonPanel.add(buttons[i]);//add 1,2,3

		equalButton.addActionListener(this);

		buttons[0] = new Button("0");
		buttonPanel.add(buttons[0]);// add 0
		buttons[10] = new Button(".");
		buttonPanel.add(buttons[10]); //add decimal
		buttons[11] = new Button("Clear");
		buttonPanel.add(buttons[11]); // add clear

		for(int i = 0; i<buttons.length; i++)
		{
			buttons[i].addActionListener(this);
		}


		setMenuBar(mnuBar);
		mnuBar.add(mnuFile);
		mnuBar.add(mnuUnits);

		mnuFile.add(mnuFileExit);

		mnuUnits.add(mnuUnitsMetric);
		mnuUnits.add(mnuUnitsUSA);
		mnuUnits.add(mnuUnitsTroy);

		mnuUnitsMetric.add(mnuUnitsMetricLength);
		mnuUnitsMetricLength.add(mnuUnitsMetricLengthCentimeter);
		mnuUnitsMetricLength.add(mnuUnitsMetricLengthMeters);
		mnuUnitsMetricLength.add(mnuUnitsMetricLengthKilometer);

		mnuUnitsUSA.add(mnuUnitsUSALength);
		mnuUnitsUSALength.add(mnuUnitsUSALengthInch);
		mnuUnitsUSALength.add(mnuUnitsUSALengthFeet);
		mnuUnitsUSALength.add(mnuUnitsUSALengthYards);
		mnuUnitsUSALength.add(mnuUnitsUSALengthMile);

		mnuUnitsUSA.add(mnuUnitsUSAWeight);
		mnuUnitsUSAWeight.add(mnuUnitsUSAWeightOunces);
		mnuUnitsUSAWeight.add(mnuUnitsUSAWeightPounds);
		mnuUnitsUSAWeight.add(mnuUnitsUSAWeightTons);

		mnuUnitsMetric.add(mnuUnitsMetricWeight);
		mnuUnitsMetricWeight.add(mnuUnitsMetricWeightGrams);
		mnuUnitsMetricWeight.add(mnuUnitsMetricWeightKilograms);

		mnuUnitsUSA.add(mnuUnitsUSAArea);
		mnuUnitsUSAArea.add(mnuUnitsUSAAreaFeetSquare);
		mnuUnitsUSAArea.add(mnuUnitsUSAAreaAcre);
		mnuUnitsUSAArea.add(mnuUnitsUSAAreaSection);

		mnuUnitsMetric.add(mnuUnitsMetricArea);
		mnuUnitsMetricArea.add(mnuUnitsMetricAreaMeterSquare);
		mnuUnitsMetricArea.add(mnuUnitsMetricAreaKilometerSquare);

		mnuUnitsMetric.add(mnuUnitsMetricFluids);
		mnuUnitsMetricFluids.add(mnuUnitsMetricFluidsMilliLiter);
		mnuUnitsMetricFluids.add(mnuUnitsMetricFluidsLiter);

		mnuUnitsUSA.add(mnuUnitsUSAFluids);
		mnuUnitsUSAFluids.add(mnuUnitsUSAFluidsOunces);
		mnuUnitsUSAFluids.add(mnuUnitsUSAFluidsCups);
		mnuUnitsUSAFluids.add(mnuUnitsUSAFluidsPints);
		mnuUnitsUSAFluids.add(mnuUnitsUSAFluidsQuarts);
		mnuUnitsUSAFluids.add(mnuUnitsUSAFluidsGallon);

		mnuUnitsUSA.add(mnuUnitsUSATemp);
		mnuUnitsUSATemp.add(mnuUnitsUSATempFahrenheit);

		mnuUnitsMetric.add(mnuUnitsMetricTemp);
		mnuUnitsMetricTemp.add(mnuUnitsMetricTempCelsius);
		mnuUnitsMetricTemp.add(mnuUnitsMetricTempKelvin);

		mnuUnitsTroy.add(mnuUnitsTroyOunce);
		mnuUnitsTroy.add(mnuUnitsTroyPound);
		mnuUnitsTroy.add(mnuUnitsTroyGrain);
		mnuUnitsTroy.add(mnuUnitsTroyPenny);

		mnuFile.addActionListener(this);
		mnuFileExit.addActionListener(this);
		mnuUnitsUSAFluidsOunces.addActionListener(this);
		mnuUnitsUSAFluidsCups.addActionListener(this);
		mnuUnitsUSAFluidsPints.addActionListener(this);
		mnuUnitsUSAFluidsQuarts.addActionListener(this);
		mnuUnitsUSAFluidsGallon.addActionListener(this);
		mnuUnitsUSALengthFeet.addActionListener(this);
		mnuUnitsUSALengthYards.addActionListener(this);
		mnuUnitsUSALengthMile.addActionListener(this);
		mnuUnitsUSALengthInch.addActionListener(this);
		mnuUnitsUSAWeightOunces.addActionListener(this);
		mnuUnitsUSAWeightPounds.addActionListener(this);
		mnuUnitsUSAWeightTons.addActionListener(this);
		mnuUnitsUSAAreaFeetSquare.addActionListener(this);
		mnuUnitsUSAAreaAcre.addActionListener(this);
		mnuUnitsUSAAreaSection.addActionListener(this);
		mnuUnitsMetricLengthMeters.addActionListener(this);
		mnuUnitsMetricLengthKilometer.addActionListener(this);
		mnuUnitsMetricLengthCentimeter.addActionListener(this);
		mnuUnitsMetricWeightGrams.addActionListener(this);
		mnuUnitsMetricWeightKilograms.addActionListener(this);
		mnuUnitsMetricAreaMeterSquare.addActionListener(this);
		mnuUnitsMetricAreaKilometerSquare.addActionListener(this);
		mnuUnitsMetricFluidsMilliLiter.addActionListener(this);
		mnuUnitsMetricFluidsLiter.addActionListener(this);
		mnuUnitsMetricTempCelsius.addActionListener(this);
		mnuUnitsMetricTempKelvin.addActionListener(this);
		mnuUnitsUSATempFahrenheit.addActionListener(this);
		mnuUnitsTroyPound.addActionListener(this);
		mnuUnitsTroyGrain.addActionListener(this);
		mnuUnitsTroyOunce.addActionListener(this);
		mnuUnitsTroyPenny.addActionListener(this);

		mnuFileExit.setActionCommand("Exit");
		mnuUnitsUSAFluidsOunces.setActionCommand("WetOunces");
		mnuUnitsUSAFluidsCups.setActionCommand("Cups");
		mnuUnitsUSAFluidsPints.setActionCommand("Pints");
		mnuUnitsUSAFluidsQuarts.setActionCommand("Quarts");
		mnuUnitsUSAFluidsGallon.setActionCommand("Gallon");
		mnuUnitsUSALengthFeet.setActionCommand("Feet");
		mnuUnitsUSALengthYards.setActionCommand("Yards");
		mnuUnitsUSALengthMile.setActionCommand("Mile");
		mnuUnitsUSALengthInch.setActionCommand("Inch");
		mnuUnitsUSAWeightOunces.setActionCommand("DryOunces");
		mnuUnitsUSAWeightPounds.setActionCommand("Pounds");
		mnuUnitsUSAWeightTons.setActionCommand("Tons");
		mnuUnitsUSAAreaFeetSquare.setActionCommand("Square Feet");
		mnuUnitsUSAAreaAcre.setActionCommand("Acre");
		mnuUnitsUSAAreaSection.setActionCommand("Section");
		mnuUnitsMetricLengthMeters.setActionCommand("Meters");
		mnuUnitsMetricLengthKilometer.setActionCommand("Kilometers");
		mnuUnitsMetricLengthCentimeter.setActionCommand("Centimeters");
		mnuUnitsMetricWeightGrams.setActionCommand("Grams");
		mnuUnitsMetricWeightKilograms.setActionCommand("Kilograms");
		mnuUnitsMetricAreaMeterSquare.setActionCommand("Square Meters");
		mnuUnitsMetricAreaKilometerSquare.setActionCommand("Square Kilometers");
		mnuUnitsMetricFluidsMilliLiter.setActionCommand("MilliLiter");
		mnuUnitsMetricFluidsLiter.setActionCommand("Liter");
		mnuUnitsMetricTempCelsius.setActionCommand("Celsius");
		mnuUnitsMetricTempKelvin.setActionCommand("Kelvin");
		mnuUnitsUSATempFahrenheit.setActionCommand("Fahrenheit");
		mnuUnitsTroyPound.setActionCommand("Troy Pound");
		mnuUnitsTroyOunce.setActionCommand("Troy Ounce");
		mnuUnitsTroyPenny.setActionCommand("Pennyweight");
		mnuUnitsTroyGrain.setActionCommand("Grain");

		addWindowListener(
				new WindowAdapter()
				{
	 				public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				}
			);
		invalidate();
		validate();

	}

	public void actionPerformed(ActionEvent e)
	{
		invalidate();
		validate();
		 //ActionCommands
		if(e.getActionCommand() == "Exit")
		{
			System.exit(0);
		}

		if(e.getActionCommand() == "Feet")
			{
				if(first)
				{
					mnuUnitsMetricFluids.setEnabled(false);
					mnuUnitsMetricArea.setEnabled(false);
					mnuUnitsMetricWeight.setEnabled(false);
					mnuUnitsUSAWeight.setEnabled(false);
					mnuUnitsUSAArea.setEnabled(false);
					mnuUnitsUSAFluids.setEnabled(false);
					mnuUnitsUSALengthFeet.setEnabled(false);
					mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
					inputLabel.setText("Feet");
					first = false;
				}

				else
					outputLabel.setText("Feet");

			}

		if(e.getActionCommand() == "Inch")
			{
				if(first)
				{
					mnuUnitsMetricFluids.setEnabled(false);
					mnuUnitsMetricArea.setEnabled(false);
					mnuUnitsMetricWeight.setEnabled(false);
					mnuUnitsUSAWeight.setEnabled(false);
					mnuUnitsUSAArea.setEnabled(false);
					mnuUnitsUSAFluids.setEnabled(false);
					mnuUnitsUSALengthInch.setEnabled(false);
					mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
					first = false;
					inputLabel.setText("Inches");


				}

				else
				outputLabel.setText("Inches");

			}

		if(e.getActionCommand() == "Yards")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSALengthYards.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Yards");
			}

			else
				outputLabel.setText("Yards");
		}

		if(e.getActionCommand() == "Mile")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSALengthMile.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Miles");
			}

			else
				outputLabel.setText("Miles");
		}

		if(e.getActionCommand() == "WetOunces")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAFluidsOunces.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Fluid Ounces");
			}

			else
				outputLabel.setText("Fluid Ounces");
		}

		if(e.getActionCommand() == "Cups")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAFluidsCups.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Cups");
			}

			else
				outputLabel.setText("Cups");
		}

		if(e.getActionCommand() == "Pints")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAFluidsPints.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Pints");
			}

			else
				outputLabel.setText("Pints");
		}

		if(e.getActionCommand() == "Quarts")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluidsQuarts.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Quarts");
			}

			else
				outputLabel.setText("Quarts");
		}

		if(e.getActionCommand() == "Gallon")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluidsGallon.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Gallon");
			}

			else
				outputLabel.setText("Gallon");
		}

		if(e.getActionCommand() == "DryOunces")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsUSAWeightOunces.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				first = false;
				inputLabel.setText("Dry Ounces");
			}

			else
				outputLabel.setText("Dry Ounces");
		}

		if(e.getActionCommand() == "Pounds")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsUSAWeightPounds.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				first = false;
				inputLabel.setText("Pounds");
			}

			else
				outputLabel.setText("Pounds");
		}

		if(e.getActionCommand() == "Tons")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAWeightTons.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				first = false;
				inputLabel.setText("Tons");
			}

			else
				outputLabel.setText("Tons");
		}

		if(e.getActionCommand() == "Square Feet")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSAAreaFeetSquare.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Square Feet");
			}

			else
				outputLabel.setText("Square Feet");
		}

		if(e.getActionCommand() == "Acre")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSAAreaAcre.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Acres");
			}

			else
				outputLabel.setText("Acres");
		}

		if(e.getActionCommand() == "Section")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSAAreaSection.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Sections");
			}

			else
				outputLabel.setText("Sections");
		}

		if(e.getActionCommand() == "Meters")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsMetricLengthMeters.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Meters");
			}

			else
				outputLabel.setText("Meters");
		}

		if(e.getActionCommand() == "Kilometers")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricLengthKilometer.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Kilometers");
			}

			else
				outputLabel.setText("Kilometers");
		}

		if(e.getActionCommand() == "Centimeters")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricLengthCentimeter.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Centimeters");
			}

			else
				outputLabel.setText("Centimeters");
		}

		if(e.getActionCommand() == "Grams")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricWeightGrams.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
				first = false;
				inputLabel.setText("Grams");
			}

			else
				outputLabel.setText("Grams");
		}

		if(e.getActionCommand() == "Kilograms")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricWeightKilograms.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
				first = false;
				inputLabel.setText("Kilograms");
			}

			else
				outputLabel.setText("Kilograms");
		}

		if(e.getActionCommand() == "Square Meters")
		{
			if(first)
			{
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsMetricAreaMeterSquare.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Square Meters");
			}

			 else
				outputLabel.setText("Square Meters");
		}

		if(e.getActionCommand() == "Square Kilometers")
		{
			if(first)
			{
			 mnuUnitsMetricFluids.setEnabled(false);
			 mnuUnitsMetricLength.setEnabled(false);
			 mnuUnitsMetricWeight.setEnabled(false);
			 mnuUnitsMetricAreaKilometerSquare.setEnabled(false);
			 mnuUnitsUSAWeight.setEnabled(false);
			 mnuUnitsUSALength.setEnabled(false);
			 mnuUnitsUSAFluids.setEnabled(false);
			 mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
			 first = false;
			 inputLabel.setText("Square Kilometers");
		}

		 else
		 outputLabel.setText("Square Kilometers");
		}

		if(e.getActionCommand() == "MilliLiter")
		{
			if(first)
			{
				 mnuUnitsMetricLength.setEnabled(false);
				 mnuUnitsMetricArea.setEnabled(false);
				 mnuUnitsMetricWeight.setEnabled(false);
				 mnuUnitsMetricFluidsMilliLiter.setEnabled(false);
				 mnuUnitsUSAWeight.setEnabled(false);
				 mnuUnitsUSAArea.setEnabled(false);
				 mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				 inputLabel.setText("MilliLiters");
			}

			else
			 outputLabel.setText("MilliLiters");
		}

		if(e.getActionCommand() == "Liter")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsMetricFluidsLiter.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
					mnuUnitsMetricTemp.setEnabled(false);
					mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Liters");
			}

			else
				outputLabel.setText("Liters");
		}

		if(e.getActionCommand() == "Celsius")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricTempCelsius.setEnabled(false);
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsMetricTempCelsius.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Celsius");
			}

			else
				outputLabel.setText("Celsius");
		}

		if(e.getActionCommand() == "Kelvin")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricTempKelvin.setEnabled(false);
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsMetricTempKelvin.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Kelvin");
			}

			else
				outputLabel.setText("Kelvin");
		}

		if(e.getActionCommand() == "Fahrenheit")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricWeight.setEnabled(false);
				mnuUnitsUSAWeight.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsUSATempFahrenheit.setEnabled(false);
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsUSATempFahrenheit.setEnabled(false);
				mnuUnitsTroy.setEnabled(false);
				first = false;
				inputLabel.setText("Fahrenheit");
			}

			else
				outputLabel.setText("Fahrenheit");
		}

		if(e.getActionCommand() == "Troy Pound")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsTroyPound.setEnabled(false);
				first = false;
				inputLabel.setText("Troy Pound");
			}

			else
				outputLabel.setText("Troy Pound");
		}

		if(e.getActionCommand() == "Grain")
		{
			if(first)
			{

				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsTroyGrain.setEnabled(false);
				first = false;
				inputLabel.setText("Troy Grain");
			}

			else
				outputLabel.setText("Troy Grain");
		}

		if(e.getActionCommand() == "Troy Ounce")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsTroyOunce.setEnabled(false);
				first = false;
				inputLabel.setText("Troy Ounce");
			}

			else
				outputLabel.setText("Troy Ounce");
		}

		if(e.getActionCommand() == "Pennyweight")
		{
			if(first)
			{
				mnuUnitsMetricLength.setEnabled(false);
				mnuUnitsMetricArea.setEnabled(false);
				mnuUnitsMetricTemp.setEnabled(false);
				mnuUnitsUSATemp.setEnabled(false);
				mnuUnitsUSAArea.setEnabled(false);
				mnuUnitsUSALength.setEnabled(false);
				mnuUnitsMetricFluids.setEnabled(false);
				mnuUnitsUSAFluids.setEnabled(false);
				mnuUnitsTroyPenny.setEnabled(false);
				first = false;
				inputLabel.setText("Troy Pennyweight");
			}

			else
				outputLabel.setText("Troy Pennyweight");
		}

		//Button Clicks
		if(e.getSource() == buttons[11])
		{
			 inputField.setText("");
			 outputField.setText("");
			 first = true;
			 inputLabel.setText("");
			 outputLabel.setText("");
			 mnuUnitsUSAWeight.setEnabled(true);
			 mnuUnitsUSALength.setEnabled(true);
			 mnuUnitsUSAArea.setEnabled(true);
			 mnuUnitsUSAFluids.setEnabled(true);
			 mnuUnitsMetricLength.setEnabled(true);
			 mnuUnitsMetricWeight.setEnabled(true);
			 mnuUnitsMetricArea.setEnabled(true);
			 mnuUnitsMetricFluids.setEnabled(true);
			 mnuUnitsUSAFluidsOunces.setEnabled(true);
			 mnuUnitsUSAFluidsCups.setEnabled(true);
			 mnuUnitsUSAFluidsPints.setEnabled(true);
			 mnuUnitsUSAFluidsQuarts.setEnabled(true);
			 mnuUnitsUSAFluidsGallon.setEnabled(true);
			 mnuUnitsUSALengthFeet.setEnabled(true);
			 mnuUnitsUSALengthYards.setEnabled(true);
			 mnuUnitsUSALengthMile.setEnabled(true);
			 mnuUnitsUSALengthInch.setEnabled(true);
			 mnuUnitsUSAWeightOunces.setEnabled(true);
			 mnuUnitsUSAWeightPounds.setEnabled(true);
			 mnuUnitsUSAWeightTons.setEnabled(true);
			 mnuUnitsUSAAreaFeetSquare.setEnabled(true);
			 mnuUnitsUSAAreaAcre.setEnabled(true);
			 mnuUnitsUSAAreaSection.setEnabled(true);
			 mnuUnitsMetricLengthMeters.setEnabled(true);
			 mnuUnitsMetricLengthKilometer.setEnabled(true);
			 mnuUnitsMetricLengthCentimeter.setEnabled(true);
			 mnuUnitsMetricWeightGrams.setEnabled(true);
			 mnuUnitsMetricWeightKilograms.setEnabled(true);
			 mnuUnitsMetricAreaMeterSquare.setEnabled(true);
			 mnuUnitsMetricAreaKilometerSquare.setEnabled(true);
			 mnuUnitsMetricFluidsMilliLiter.setEnabled(true);
			 mnuUnitsMetricFluidsLiter.setEnabled(true);
			 mnuUnitsMetricTempCelsius.setEnabled(true);
			 mnuUnitsMetricTempKelvin.setEnabled(true);
			 mnuUnitsUSATempFahrenheit.setEnabled(true);
			 mnuUnitsUSATemp.setEnabled(true);
			 mnuUnitsMetricTemp.setEnabled(true);
			 mnuUnitsTroyPound.setEnabled(true);
			 mnuUnitsTroyOunce.setEnabled(true);
			 mnuUnitsTroyPenny.setEnabled(true);
			 mnuUnitsTroyGrain.setEnabled(true);
			 mnuUnitsTroy.setEnabled(true);
		}

		for(int i = 0; i<11; i++)
		{
			if(e.getSource() == buttons[i])
			{
				 inputField.setText(inputField.getText() + buttons[i].getLabel());
			}
		}
		 invalidate();
		 validate();

		 //calulations based on labels
		if(e.getSource() == equalButton)
		{
			if(inputLabel.getText() == "Feet")
			{
				if(outputLabel.getText() == "Inches")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 12;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Yards")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement / 3;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() =="Miles")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement /5280;
					outputField.setText("" + output);

				}

				else if(outputLabel.getText() =="Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.3048;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() =="Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * (0.3048/1000);
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Centimeters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * (0.3048 * 100);
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() =="Inches")
			{
				if(outputLabel.getText() =="Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement / 12;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() =="Yards")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement / 36;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0254;
					outputField.setText(""+output);
				}

				else if(outputLabel.getText() =="Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0000254;
					outputField.setText(""+output);
				}

				else if(outputLabel.getText() =="Miles")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0000157828283;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Centimeters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2.54;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() =="Yards")
			{
				if(outputLabel.getText() =="Inches")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 36;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() =="Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 3;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Miles")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.000568181818;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.9144;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0009144;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Centimeters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 91.44;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Miles")
			{
				if(outputLabel.getText() == "Inches")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 63360;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 5280;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Yards")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * (5280/3);
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1609.344;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1.609344;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Centimeters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 160934.4;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Meters")
			{
				if(outputLabel.getText() == "Inches")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 39.3700787;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 3.2808399;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Yards")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1.0936133;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Miles")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.000621371192;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.001;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Centimeters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 100;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Kilometers")
			{
				if(outputLabel.getText() == "Inches")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 39370.0787;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 3280.8399;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Yards")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1093.6133;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Miles")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1000;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Centimeters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 100000;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Centimeters")
			{
				if(outputLabel.getText() == "Inches")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.393700787;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.032808399;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Yards")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.010936133;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Miles")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00000621371192;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.01;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.000001;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Dry Ounces")
			{
				if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement / 16;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0000312500;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 28.3495231;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0283495231;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 14.583333333333333333333333333333;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Grain")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 437.5;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Ounce")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.911458333;
					outputField.setText("" + output);
				}


				else if(outputLabel.getText() == "Troy Pennyweight")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 18.2291667;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Pounds")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 16;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement / 2000;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 453.59237;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.45359237;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 14.583333333333333333333333333333;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Grain")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 437.5;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Ounce")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 0.911458333;
									outputField.setText("" + output);
								}


								else if(outputLabel.getText() == "Troy Pennyweight")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 18.2291667;
									outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Tons")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2000;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 907184.74;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 907.18474;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 14.583333333333333333333333333333;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Grain")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 437.5;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Ounce")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 0.911458333;
									outputField.setText("" + output);
								}


								else if(outputLabel.getText() == "Troy Pennyweight")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 18.2291667;
									outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Grams")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0352739619;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0352739619;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00000110231131;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement / 1000;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 14.583333333333333333333333333333;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Grain")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 437.5;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Ounce")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 0.911458333;
									outputField.setText("" + output);
								}


								else if(outputLabel.getText() == "Troy Pennyweight")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 18.2291667;
									outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Kilograms")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 35.2739619;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2.20462262;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00110231131;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1000;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 14.583333333333333333333333333333;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Grain")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 437.5;
									outputField.setText("" + output);
								}

								else if(outputLabel.getText() == "Troy Ounce")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 0.911458333;
									outputField.setText("" + output);
								}


								else if(outputLabel.getText() == "Troy Pennyweight")
								{
									measurement = Double.parseDouble(inputField.getText());
									output = measurement * 18.2291667;
									outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Square Feet")
			{
				if(outputLabel.getText() == "Acres")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0000229568411;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Sections")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0000000358700643;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.09290304;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00000009290304;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Acres")
			{
				if(outputLabel.getText() == "Square Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 43560;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Sections")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0015625;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 4046.85642;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00404685642;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Sections")
			{
				if(outputLabel.getText() == "Square Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 27878400;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Acres")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 640;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2589988.11;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2.58998811;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Square Meters")
			{
				if(outputLabel.getText() == "Square Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 10.7639104;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Acres")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.000247105381;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Sections")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0000000386102159;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Kilometers")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.000001;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Square Kilometers")
			{
				if(outputLabel.getText() == "Square Feet")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 10763910.4;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Acres")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 247.105381;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Sections")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.386102159;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Square Meters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1000000;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Fluid Ounces")
			{
				if(outputLabel.getText() == "Cups")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.125;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pints")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0625;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Quarts")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.03125;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Gallons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0078125;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "MilliLiters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 29.5735296;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Liters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0295735296;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Cups")
			{
				if(outputLabel.getText() == "Fluid Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 8;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pints")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.5;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Quarts")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.25;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Gallons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0625;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "MilliLiters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 236.588237;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Liters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.236588236;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Pints")
			{
				if(outputLabel.getText() == "Fluid Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 16;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Cups")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Quarts")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.5;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Gallons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.125;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "MilliLiters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 473.176473;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Liters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.473176473;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Quarts")
			{
				if(outputLabel.getText() == "Fluid Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 32;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Cups")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 4;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pints")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Gallons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.25;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "MilliLiters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 946.352946;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Liters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.946352946;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Gallon")
			{
				if(outputLabel.getText() == "Fluid Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 128;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Cups")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 16;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pints")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 8;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Quarts")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 4;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "MilliLiters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 3785.41178;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Liters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 3.78541178;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "MilliLiters")
			{
				if(outputLabel.getText() == "Fluid Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.0338140227;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Cups")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00422675284;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pints")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00211337642;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Quarts")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.00105668821;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Gallons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.000264172052;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Liters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.001;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Liters")
			{
				if(outputLabel.getText() == "Fluid Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 33.8140227;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Cups")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 4.22675284;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pints")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 2.11337642;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Quarts")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1.05668821;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Gallons")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 0.264172052;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "MilliLiters")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement * 1000;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Celsius")
			{
				if(outputLabel.getText() == "Kelvin")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement + 273.15;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Fahrenheit")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = (measurement - 32) * 5/9;
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Kelvin")
			{
				if(outputLabel.getText() == "Celsius")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = measurement - 273.15;
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Fahrenheit")
				{
					measurement = Double.parseDouble(inputField.getText());
					output =  ((measurement - 273) * 1.8 ) + 32;
					outputField.setText(""+ output);
				}
			}

			if(inputLabel.getText() == "Fahrenheit")
			{
				if(outputLabel.getText() == "Celsius")
				{
					measurement = Double.parseDouble(inputField.getText());
					output = (measurement- 32) * 5/9 ;
					outputField.setText(""+ output);
				}

				else if(outputLabel.getText() == "Kelvin")
				{
					measurement = Double.parseDouble(inputField.getText());
					output =  (measurement - 32) * 5/9 + (273);
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Troy Pennyweight")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Ounce")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Grain")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Troy Ounce")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Grain")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pennyweight")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Troy Pound")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Ounce")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Grain")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pennyweight")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}
			}

			if(inputLabel.getText() == "Troy Grain")
			{
				if(outputLabel.getText() == "Dry Ounces")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Pounds")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Tons")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Grams")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Kilograms")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pound")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Ounce")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}

				else if(outputLabel.getText() == "Troy Pennyweight")
				{
					measurement = Double.parseDouble(inputField.getText());
					outputField.setText("" + output);
				}
			}
		}
	}

	public static void main(String args[])
	{
		UnitConverter f = new UnitConverter();
		f.setVisible(true);
		f.setBounds(20,20,750,500);
		f.setTitle("Units Converter");
	}
}