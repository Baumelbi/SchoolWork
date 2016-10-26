Heads Up
Working Requirements as of 4/13/16

Purpose: Design a Heads Up game using Android accelerometer to go through list of words. Heads up is a game
		 like charades, but the person posts the word on their forehead and has to get the word on their forehead
		 (which isn't visible to themselves). Other people will have to describe the word without actually using
		 the word. A person has one minute to get as many points as possible.

Scoring:
	-Upon scoring, the word that you got correct will be saved, along with a score
	-If answer is skipped, no points awarded
	-The end of the game will display the amount of points scored, as well as the list of
	 words answered correctly
	 
Integration:
	-When the word is either passed or answered correctly, the next word will be prompted (through the use of the accelerometer)

Words to Guess:
	-Players will go through a randomized words (random order) in a prebuilt list of categories (such as animals)
	-Words are in random order
	-Words will all be from the same category

Rules to Game:
	-Person holding the card on head can not look at the word
	-Person must get the person holding the card to say the word (through either acting or guiding a person to the correct word)
	
Features:
	-Use of accelerometer to cycle through words (motion down for a correct word, motion up for a skipped word)
	-Library of words to guess through must be categorized
	-Words are in random order, and must not be repeated through set
	-One round is one minute
	-An indicator that shows an answer is correct must be displayed
	-Orientation of the card should be in landscape when in play
	-There shall be an indication that the round has ended
	-Scorecard at the end of a round should be in portrait mode
	-Words that were skipped shall also be in the end scorecard
	-Scorecard at end will be a different activity
	(Feel free to add mroe things, this was a pretty quick list)


