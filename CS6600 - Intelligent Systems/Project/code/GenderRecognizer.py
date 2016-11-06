import pyAudioAnalysis;
# import seewave;
# import fftw;
# import caTools;
# import randomForest;
# import warbleR;
# import mice;
# import e1071;
# import rpart;
# import xgboost;
# import e1071;
import scipy.io as io;

from pyAudioAnalysis import audioTrainTest as aT
from pyAudioAnalysis import audioFeatureExtraction

aT.featureAndTrain(["classifierData/music","classifierData/speech"], 1.0, 1.0, aT.shortTermWindow, aT.shortTermStep, "svm", "svmSMtemp", False)
aT.fileClassification("data/doremi.wav", "svmSMtemp","svm") #first parameter in this method is for location of source wav file. and the next parameter is the trained classifier
Result:
(0.0, array([ 0.90156761,  0.09843239]), ['music', 'speech'])