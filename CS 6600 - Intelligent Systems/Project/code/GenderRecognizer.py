# import pyAudioAnalysis
# import scipy.io
# import numpy
import rpy2.robjects as robjects

# from pyAudioAnalysis import audioBasicIO
# #from pyAudioAnalysis import audioTrainTest as aT
# from pyAudioAnalysis import audioFeatureExtraction
#
# def midTermFeatureExtraction(signal, Fs, mtWin, mtStep, stWin, stStep):
#     mtWinRatio = int(round(mtWin / stStep))
#     mtStepRatio = int(round(mtStep / stStep))
#
#     mtFeatures = []
#
#     stFeatures = audioFeatureExtraction.stFeatureExtraction(signal, Fs, stWin, stStep)
#     numOfFeatures = len(stFeatures)
#     numOfStatistics = 2
#
#     mtFeatures = []
#     # for i in range(numOfStatistics * numOfFeatures + 1):
#     for i in range(numOfStatistics * numOfFeatures):
#         mtFeatures.append([])
#
#     for i in range(numOfFeatures):  # for each of the short-term features:
#         curPos = 0
#         N = len(stFeatures[i])
#         while (curPos < N):
#             N1 = curPos
#             N2 = curPos + mtWinRatio
#             if N2 > N:
#                 N2 = N
#             curStFeatures = stFeatures[i][N1:N2]
#
#             mtFeatures[i].append(numpy.mean(curStFeatures))
#             mtFeatures[i + numOfFeatures].append(numpy.std(curStFeatures))
#             # mtFeatures[i+2*numOfFeatures].append(numpy.std(curStFeatures) / (numpy.mean(curStFeatures)+0.00000010))
#             curPos += mtStepRatio
#
#     return numpy.array(mtFeatures)
#
# # aT.featureAndTrain(["classifierData/music","classifierData/speech"], 1.0, 1.0, aT.shortTermWindow, aT.shortTermStep, "svm", "svmSMtemp", False) #this code first trains an audio segment classifier, given a set of WAV files stored in folders
# # aT.fileClassification("data/doremi.wav", "svmSMtemp","svm") #first parameter in this method is for location of source wav file. and the next parameter is the trained classifier
#
# [Fs, x] = audioBasicIO.readAudioFile("data/3WORDS.wav");
# #F = audioFeatureExtraction.stFeatureExtraction(x, Fs, 0.050*Fs, 0.025*Fs);
# Fm = midTermFeatureExtraction(x, Fs, round(1.0 * Fs), round(1.0 * Fs), round(Fs * 1.0), round(Fs * 1.0));
# audioFeatureExtraction.mtFeatureExtractionToFile(fileName="data/3WORDS.wav", midTermSize=1.0, midTermStep=1.0, shortTermSize=0.050, shortTermStep=0.050, outPutFile="data/a", storeStFeatures=False, storeToCSV=True, PLOT=False);
# print "Anuj"
# print Fm

robjects.r['source']("sound.r")
print "Anuj"