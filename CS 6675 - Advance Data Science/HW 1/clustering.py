from sklearn.cluster import KMeans
import numpy as np
import csv
import matplotlib as plot

CLUSTERS_COUNT = 2

FILE_IN = 'tweets_sentiment.csv'

#csv file reading
val1=[]
val2=[]

def csvReader():
    count = 0
    with open('tweets_sentiment1.csv','r', encoding="utf8") as tweetCSV:
        csvFile = csv.reader(tweetCSV)
        for col in csvFile:
            val1=col[2]
            val2=col[16]
            count+=1
            data = [count, int(val1), float(val2)]
            print(data)
        kmeans = KMeans(n_clusters=2, random_state=0).fit(data)

#        plot.plot(kmeans)

csvReader()
