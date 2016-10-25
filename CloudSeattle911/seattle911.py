"""This program will call to the seattle 911 api and recieve information realting to 
the given latitude and longitude as well as the radius of the circle. The returned
information will be ranked by most common instance to least common"""

#!/usr/bin/env python

# make sure to install these packages before running:
# pip install pandas
# pip install bokeh

import numpy as np
import pandas as pd
import datetime
import urllib

from bokeh.plotting import *
from bokeh.models import HoverTool
from collections import OrderedDict

#the input values are requested here
latitude = float(eval(input("what is your latitude: ")))
longitude = float(eval(input("what is your longitude: ")))

#the hard coded values of our location downtown.
#latitude = 47.608918
#longitude = -122.334732
radius = float(eval(input("what radius would you like in miles: "))*1609)

#the call to the API with the input values
query = ("https://data.seattle.gov/resource/pu5n-trf4.json?$where=within_circle(incident_location,{},{},{})".format(latitude,longitude,radius))
raw_data = pd.read_json(query)
#print(query)
counts = raw_data['event_clearance_group'].value_counts()
print('Crime events by count in your area')
print()
print(counts)