import pyAudioAnalysis
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
import scipy.io

from pyAudioAnalysis import audioBasicIO
#from pyAudioAnalysis import audioTrainTest as aT
from pyAudioAnalysis import audioFeatureExtraction

# aT.featureAndTrain(["classifierData/music","classifierData/speech"], 1.0, 1.0, aT.shortTermWindow, aT.shortTermStep, "svm", "svmSMtemp", False) #this code first trains an audio segment classifier, given a set of WAV files stored in folders
# aT.fileClassification("data/doremi.wav", "svmSMtemp","svm") #first parameter in this method is for location of source wav file. and the next parameter is the trained classifier

[Fs, x] = audioBasicIO.readAudioFile("data/3WORDS.wav");
F = audioFeatureExtraction.stFeatureExtraction(x, Fs, 0.050*Fs, 0.025*Fs);
print "Anuj"
print F.size
