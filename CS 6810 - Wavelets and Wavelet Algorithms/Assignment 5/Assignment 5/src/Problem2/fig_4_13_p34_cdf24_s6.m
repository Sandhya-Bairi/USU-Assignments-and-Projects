%% ========================================================================
%% Programmatic octave notes on "Ripples in Mathematics" by A. Jensen
%% and A. la Cour-Harbo written with a deep gratitude to the authors for
%% this wonderful text. 
%% 
%% Reconstruction of graphs in Figure 4.13, top, p.34, Ch 04, S6, CDF(2,4)
%%
%% Author: Vladimir Kulyukin
%% 
%% NB: I have tested this code in Octave 4.
%% =========================================================================
t = [0:1023];

y_fig_4_13_s6_p34 = [
0.8334374694168124
0.8746018454451339
0.9000520197714186
0.9297128017534636
0.9436593820334725
0.9618165699692416
0.9841843655607714
1.0054239322312957
1.0109492971997835
1.0206852698240316
1.0346318501040406
1.0474502014630438
1.0644791604778079
1.0803798905715662
1.0951523917443196
1.1102272009453331
1.1095878084443114
1.1131590235990494
1.120940846409548
1.1275944402990412
1.1384586418442948
1.1481946144685429
1.156802358171786
1.1657124099032892
1.1788330692905538
1.1908254997568126
1.2016897013020662
1.2128562108755803
1.2228944915280895
1.2332350802088594
1.2438779769178898
1.254439870434882
1.2110979812394718
1.1821995670908323
1.1677446279889643
1.1494195714124142
1.1455379898826357
1.1377862908781755
1.126164474399034
1.1155796527718467
1.1194383061914315
1.1194268421363345
1.1155452606065561
1.1127006739287317
1.1059859697762262
1.1003082604756749
1.0956675460270784
1.0907489696453452
1.1002738683103839
1.1059286495007408
1.1077133132164163
1.1105349717840463
1.1094865128769946
1.1094750488218974
1.1105005796187546
1.1112482484824753
1.1081257998715153
1.1060403461125092
1.104991887205458
1.1036655663652697
1.1033762403770364
1.1028090524556662
1.1019640026011595
1.1011934056272439
1.0804549230049674
1.0650668192167259
1.0550290942625198
1.0435577396205333
1.0374367638125825
1.0298821583168511
1.0208939231333396
1.0122898278669137
1.009036111434524
1.0043487653143537
0.9982277895064031
0.9924909536155382
0.9853204880368931
0.9785341623753336
0.9721319766308607
0.9656268609058234
0.9644721240148226
0.9618837574360412
0.9578617611694791
0.954223904820003
0.9491524187827467
0.9444650726625761
0.940161866459492
0.9357557302758437
0.9299159644044154
0.9244603384500729
0.9193888524128164
0.914214436394996
0.9094241602942621
0.904530954212964
0.8995348181511023
0.8945662620944093
0.8821806799729595
0.8717824839958015
0.863371674162936
0.8544283458176585
0.8474724036166736
0.8399839429032765
0.8319629636774675
0.8240846723570137
0.8181937671808528
0.8117703434922795
0.8048144012912944
0.7980011469956646
0.7906553741876231
0.7834522892849367
0.7763918922876059
0.7692932621812651
0.7641820182192176
0.7585382557447576
0.7523619747578856
0.7463283816763691
0.7397622700824406
0.7333388463938673
0.7270581106106495
0.7207391417184219
0.7138876543137829
0.7071788548144988
0.7006127432205703
0.6940083985176319
0.6875467417200493
0.6810468518134568
0.6745087287978546
0.6679808503129355
0.6590536341444863
0.6507693185707082
0.6431279035916019
0.6353142239173396
0.6281434448377491
0.6208004010630027
0.6132850925931008
0.6058159423091499
0.5989896926198712
0.5919911782354363
0.5848203991558458
0.5776957782622065
0.5703988926734118
0.5631481652705682
0.5559435960536762
0.5487266587881341
0.542152622117264
0.535406320751238
0.5284877546900562
0.5216153468148256
0.5145706742444396
0.5075721598600047
0.5006198036615214
0.493655079414388
0.4865180904720994
0.47942725971576183
0.47238258714537573
0.46532554652633973
0.4583146640932553
0.451291413611521
0.4442557950811369
0.43722349055940035
0.43248940333009855
0.42713951063325745
0.4211738124688774
0.41537311888221895
0.4089566198280217
0.40270512535154607
0.3966186354527922
0.39048793271069027
0.38374142450104953
0.37715992086913036
0.370743421814933
0.36428270991738754
0.35798700259756405
0.35164708243439247
0.3452629494278729
0.3388906632170234
0.33190257153863517
0.3250794844379685
0.3184214019150236
0.31171910654873064
0.30518181576015957
0.2986003121282404
0.2919745956529733
0.28536072597337625
0.2789118608715012
0.2724187829262781
0.265881492137707
0.259356048144806
0.25278639130855707
0.24622858126797825
0.23968261802306962
0.23313348043882826
0.23409327076547037
0.23304104992236763
0.22997681790952026
0.2274517026647683
0.22291457625027175
0.2189165666038706
0.21545767372556496
0.21185432494462197
0.20623896499393446
0.20116272181134237
0.1966255953968457
0.19194401307971182
0.18780154753067343
0.18351462607899777
0.17908324872468484
0.1746905782128254
0.16828589653122145
0.16242033161771288
0.15709388347229986
0.1516229794242495
0.14669119214429466
0.1416149489617025
0.13639424987647314
0.13121225763369732
0.12656938215901703
0.12178205078169944
0.1168502635017446
0.11195718306424329
0.10691964672410478
0.10192081722641977
0.09696069457118836
0.09199020044877991
0.09891657748213448
0.10265519749684521
0.10320606049291212
0.10461108040779127
0.10282834330402668
0.10189976311907432
0.10182533985293421
0.10152204593018888
0.09803099498879977
0.09539410096622289
0.09361136386245827
0.09159975610208845
0.0904423052605309
0.08905598376236815
0.08744079160760015
0.0858869251604407
0.08114530169463754
0.07725783514764659
0.07422452551946786
0.07096234523468394
0.06855432186871227
0.06591742784613538
0.06305166316695332
0.060247224195379784
0.058296942142618546
0.05611778943325208
0.05370976606728041
0.05136306840891727
0.04878750009394896
0.04627325748658918
0.04382034058683794
0.04135099151325772
0.052016677243873884
0.05916284100615092
0.06278948280008886
0.06735917766318686
0.06840935055794577
0.07040257652186471
0.07333885555494372
0.07602244427972159
0.07518651103616039
0.0752936308617592
0.0763438037565181
0.07714128634297585
0.07888182199859368
0.08036966734591036
0.08160482238492593
0.08290768558798593
0.08069102682270689
0.07941742112658785
0.0790868684996289
0.0785036255643688
0.07886343569826876
0.07897055552386757
0.0788249850411653
0.07874712272250745
0.07961231347300968
0.08022481391521077
0.08058462404911074
0.08101214234705514
0.08118697033669844
0.08142950649038619
0.08173975080811839
0.08203185277797387
0.09292906267247185
0.10098464246291694
0.1061985921493092
0.11217395432727037
0.11530768640117872
0.11920283096665595
0.12385938802370214
0.1283119252185254
0.12992283230929597
0.13229515189163538
0.13542888396554376
0.13835859617722923
0.14204972088048362
0.14553682572151513
0.1488199107003238
0.15215766263645497
0.1526537844685334
0.1539113187921807
0.15593026560739692
0.15774519256039024
0.16032153200495255
0.16269385158729197
0.16486215130740853
0.16708511798484757
0.1700694971538556
0.17284985646064072
0.17542619590520303
0.1780572023070878
0.18048418884674974
0.18296584234373417
0.18550216279804116
0.18802383528528088
0.1968130471830748
0.20392287695728045
0.2093533246078979
0.21523376134231406
0.21943481595314207
0.22408585964776867
0.22918689242619408
0.23416735099301275
0.2374684274362433
0.24121949296327252
0.24542054757410048
0.2495010279733217
0.2540314974563417
0.2584413927277549
0.2627307137875615
0.2670523426099961
0.26969458930884266
0.2727868250914879
0.2763290499579318
0.27975070061276897
0.2836223403514049
0.287373405878434
0.2910038971938566
0.2946666962719071
0.29877948443375657
0.30277169838399914
0.3066433381226351
0.310547285623899
0.3143306589135563
0.3181463399658416
0.3219943287807549
0.3258336607567627
0.33204822548595253
0.3376263485170912
0.3425680298501789
0.34768024522228874
0.35215601889634773
0.3568023266094289
0.36161916836153235
0.36639031565559765
0.3705250212516121
0.3748302608866486
0.3793060345607076
0.3837361137767284
0.3883367270317716
0.39289164582877667
0.3974008701677438
0.40192233829984053
0.40580736473388673
0.40986292520695494
0.41408901971904544
0.41826941977309773
0.42262035386617247
0.4269255935012091
0.43118513867820774
0.43545692764833605
0.4398992506574869
0.4442958792085996
0.44864681330167433
0.45300999118787877
0.45732747461604534
0.4616572018373416
0.46599917285176795
0.47033786315171255
0.4744859355173582
0.47868508380456204
0.4829353080133243
0.4871718464701522
0.49145946084853875
0.4957333894749908
0.4999936323495088
0.5042575423102053
0.5085725281924602
0.5128738283227808
0.5171614427011672
0.521452724165732
0.5257303198783629
0.5300115826771722
0.5342965125621602
0.5385804598543678
0.5429154830681342
0.547236820529966
0.5515444722398639
0.5558557910359401
0.5601534240800822
0.5644547242104028
0.568759691426902
0.5730636760506209
0.577353974922406
0.5816479408803695
0.5859455739245115
0.5902422243758733
0.5945425419134139
0.5988418768581742
0.6031402292101545
0.6074388448470767
0.6101587865136384
0.6133017325956701
0.6168676830931721
0.6203202898991538
0.6241959011206059
0.6279581686505377
0.6316070924889496
0.6352863866779713
0.6393886852824636
0.6433776401954356
0.6472532514168877
0.6511592329889496
0.6549518708694915
0.6587748791006433
0.6626282576824052
0.6664734985532471
0.6707417438395593
0.6748966454343515
0.6789382033376237
0.6830101315915058
0.686968716153868
0.6909576710668399
0.6949769963304218
0.6989881838830838
0.7028860277442261
0.7068142419559783
0.7107728265183404
0.7147232733697826
0.7187040905718349
0.7226767700629672
0.7266413118431799
0.7306080341164616
0.7323688903483144
0.7347208066045793
0.7376637828852561
0.7404483851097133
0.7438240473585832
0.7470413355512332
0.7501002496876636
0.7532016000245598
0.756894010385869
0.7604280466909581
0.7638037089398279
0.7672218073891635
0.7704815317822796
0.7737836923758618
0.7771282891699101
0.7804615152183134
0.7843858012911293
0.7881517133077254
0.7917592512681021
0.7954092254289447
0.7989008255335679
0.802434861838657
0.8060113343442122
0.8095764361041227
0.8129831638078138
0.8164323277119707
0.8199239278165937
0.823404157175572
0.8269268227350166
0.8304381175488162
0.8339380416169712
0.8374410124672387
0.8385329536404498
0.8402709282685553
0.8426549363515559
0.8448658402920336
0.8477227776874068
0.8504066109402569
0.8529173400505847
0.8554744522761075
0.8586775979565258
0.8617076394944212
0.864564576889794
0.867467897400362
0.870198113768408
0.8729747132516492
0.8757976958500856
0.8786082501302629
0.8820648378653356
0.8853483214578856
0.8884587009079128
0.8916154634731351
0.8945991218958353
0.8976291634337306
0.9007055880868214
0.9037695844216529
0.9066604766139625
0.9095977519214671
0.9125814103441673
0.9155526404486082
0.9185702536682447
0.9215754385696219
0.9245681951527402
0.9275642818936991
0.9281567422824852
0.929393252411242
0.9312738122799697
0.9329817995409867
0.935333836541975
0.9375133009352522
0.939520192720819
0.9415733251972571
0.9442705074136671
0.9467951170223659
0.9491471540233539
0.9515454317152137
0.953771136799363
0.9560430825743839
0.9583612690402765
0.9606670653503926
0.9636169114004804
0.966394184842857
0.9689988856775229
0.9716498272030603
0.9741281961208875
0.9766528057295861
0.9792236560291567
0.9817821161729505
0.9841680037090343
0.9866001319359894
0.9890785008538163
0.9915444796158666
0.9940566990687889
0.9965565283659346
0.9990439675073033
1.0015347265809065
1.0017264131107395
1.0025341342720162
1.0039578900647366
1.0052165798754518
1.0070913043176117
1.008800962777766
1.0103455552559155
1.0119343770306408
1.014139233436811
1.0161790238609754
1.0180537483031349
1.0199727020418705
1.021726589798601
1.0235247068519076
1.0253670532017902
1.0271975483473734
1.0296440781244014
1.031925541919424
1.0340419397324412
1.0362025668420343
1.0381981279696233
1.0402379183937878
1.0423219381145286
1.0443941066309699
1.046301209165406
1.0482525409964183
1.0502481021240064
1.052231812047295
1.0542597512671608
1.0562758392827265
1.058280076093993
1.0602874884258804
1.0601376766634978
1.0605658913550675
1.0615721325005902
1.062423491924572
1.0638528778025074
1.0651273819589018
1.0662470043937557
1.0674081272608185
1.0691472765818344
1.0707315441813097
1.0721609300592447
1.0736318163693885
1.0749478209579924
1.0763053259788047
1.0777043314318266
1.079092216877552
1.0810581287772314
1.0828691589553696
1.0845253074119672
1.0862229563007737
1.0877657234680405
1.0893499910675157
1.0909757590992004
1.0925904071235886
1.094050173426437
1.0955514401614943
1.0970942073287604
1.0986258544887306
1.10019900208091
1.1017610296657934
1.1033119372433808
1.1048658244179426
1.1044120040411483
1.1044961472813772
1.1051182541386306
1.1055962140791444
1.106612137636683
1.1074839142774822
1.1082115440015423
1.1089777977755342
1.1102820151665505
1.1114420856408276
1.112458009198366
1.1135125568058355
1.1144229574965667
1.115371982237229
1.1163596310278234
1.1173369305354297
1.1188521936600608
1.1202233098679524
1.1214502791591054
1.1227158725001896
1.1238373189245352
1.1249973893988123
1.126196083923021
1.1273844291642419
1.1284286274887245
1.1295114498631382
1.130632896287484
1.1317439934288416
1.1328937146201312
1.134033086528433
1.1351621091537474
1.13629390486108
1.1355614035234216
1.13532843907342
1.1355950115110758
1.1357277334430942
1.1363599922627698
1.1368584005768079
1.137222958385209
1.137623381328502
1.1385233411594529
1.139289450484766
1.1399217093044418
1.1405898332590094
1.1411241067079398
1.141694245291762
1.1423002490104763
1.1428966426952598
1.1439925732677017
1.1449546533345054
1.1457828828956718
1.1466469775917298
1.1473772217821512
1.148143331107464
1.1489453055676693
1.1497376699939432
1.1503961839145807
1.1510905629701098
1.1518208071605307
1.1525414413170207
1.1532979406084034
1.1540448298658548
1.1547821090893757
1.155521963313727
1.1545292091460935
1.1540007059978912
1.1539364538691212
1.1537478060546085
1.1540234092595285
1.154174616778706
1.1542014286121414
1.154261572169113
1.1547859667455174
1.1551859656361794
1.155461568841099
1.155770503769555
1.1559550430122691
1.1561729139785195
1.1564241166683067
1.1566663881496895
1.1573729106505053
1.1579550374655785
1.1584127685949095
1.1589038314477764
1.1592704986149023
1.159670497505564
1.1601038281197624
1.1605282275255566
1.160828231245609
1.161161566689198
1.161528233856323
1.161885969815044
1.1622770374973024
1.1626591739711563
1.1630323792366062
1.1634079776121353
1.1621694654869659
1.161363452966953
1.160989940052097
1.1605005392173124
1.160443637987685
1.1602708488381286
1.1599821717686438
1.159724546773716
1.1598994213839458
1.1599584080742464
1.1599015068446188
1.1598756576895484
1.1597339206145496
1.159623235614108
1.159543602688224
1.1594556493840384
1.159800195685011
1.1600288540660544
1.1601416245271694
1.1602854470628412
1.160313381678585
1.1603723683688856
1.160462407133744
1.1605441255203008
1.1605099559869303
1.1605068385281163
1.16053477314386
1.1605543873813025
1.1606050536933024
1.1606473996270013
1.1606814251823994
1.1607176801764434
1.1592457531092073
1.1581779422073302
1.1575142474708124
1.156742270134138
1.1563744089628232
1.1558982651913519
1.1553138388197242
1.1547584266833624
1.1546071307123609
1.1543475521412023
1.1539796909698876
1.1536408440338386
1.1531937144976339
1.1527755991966948
1.1523864981310223
1.1519896227244406
1.1519968634832196
1.1518958216418413
1.151686497200307
1.1515061869940384
1.151217594187614
1.1509580156164554
1.1507274512805632
1.1504891126037622
1.1501424913268055
1.1498248842851144
1.1495362914786895
1.149239924331356
1.148972571419289
1.148697444166313
1.1484145425724286
1.1481337241069123
1.1464397645709277
1.1451244550435662
1.1441877955248279
1.1431496770420646
1.1424902085679252
1.1417292811297608
1.1408668947275717
1.1400316941728577
1.1395751436267678
1.1390171341166526
1.1383576656425132
1.1377253830158487
1.13699164142516
1.136285085681946
1.1356057157862078
1.1349190614645925
1.1346110571516017
1.1342015938745855
1.1336906716335449
1.1332069352399792
1.132621739882389
1.1320637303722738
1.1315329067096342
1.1309947986211177
1.1303552315685774
1.129742850363512
1.1291576550059217
1.1285651752224546
1.1279998812864633
1.1274273029245951
1.1268474401368507
1.1262695292051366
1.1243648864128664
1.1228157403512047
1.1216220910201515
1.12033318662722
1.1193997789648977
1.1183711162406964
1.1172471984546168
1.1161488041854422
1.115405906646877
1.1145677540464332
1.1136343463841105
1.112726462238693
1.1117233230313974
1.1107457073410067
1.1097936151675214
1.1088346839882932
1.108231249539675
1.1075325600291772
1.106738615456801
1.1059701944013303
1.1051065182839812
1.1042683656835368
1.1034557365999982
1.1026362685107167
1.101721545359557
1.1008323457253022
1.0999686696079527
1.0990981544848604
1.0982531628786738
1.097401332266744
1.0965426626490715
1.0956858255374642
1.0935826678732594
1.0918134607946333
1.0903782043015862
1.0888534660188212
1.0876626783216357
1.0863824088347318
1.0850126575581103
1.0836668828547806
1.082655058737031
1.0815537528295627
1.0803629651323772
1.0791961540084831
1.077939861094872
1.0767075447545524
1.0754992049875252
1.0742844407170469
1.0734036270321485
1.0724333315575318
1.0713735542931977
1.0703377536021552
1.0692124711213953
1.0681111652139272
1.0670338358797513
1.0659500820421244
1.0647768464147802
1.0636275873607277
1.0625023048799676
1.0613705978957562
1.0602628674848373
1.0591487125704673
1.0580281331526469
1.0569092751753373
1.0546214884468608
1.0526469152332687
1.0509855555345617
1.0492402705274826
1.0478081990352885
1.046292202234722
1.0446922801257843
1.0431148457354487
1.0418506248599986
1.0405024786761763
1.0390704071839822
1.0376608234103903
1.0361673143284276
1.034696292965067
1.033247759320309
1.0317932001095118
1.0306518544136
1.0294265834093161
1.0281173870966605
1.0268306785026071
1.0254600446001823
1.0241118984163597
1.0227862399511405
1.0214545559198815
1.020038946580251
1.018645824959223
1.017275191056798
1.0158985315883335
1.0145443598384722
1.013184162522571
1.0118179396406313
1.010453331304245
1.0079975493295745
1.0058341464500842
1.0039631226657746
1.0020137561390272
1.000356768707461
0.998621438533457
0.9968077656170158
0.9950150845751431
0.9935147826284518
0.9919361379393228
0.9902791505077564
0.9886431549507587
0.9869288166513239
0.9852354702264576
0.9835631156761606
0.9818851363700248
0.9804995361590704
0.9790355932056782
0.9774933075098488
0.975972013688588
0.97437237712489
0.9727937324357606
0.9712360796212005
0.9696728020508018
0.9680311817379663
0.9664105532996994
0.9648109167360013
0.9632056554164647
0.9616213859714975
0.9600314917706914
0.9584359728140471
0.9568419610061871
0.9542387960148406
0.9519060328040485
0.9498436713738109
0.9477088560048416
0.9458444424164272
0.943907574889281
0.9418982534234034
0.9399083459318973
0.9381888402209462
0.9363968805712631
0.9345324669828488
0.9326874673688059
0.9307700138160317
0.9288719742376288
0.9269933486335977
0.9251095210708116
0.9234960952885805
0.9218102155676176
0.9200518819079232
0.9183129622226002
0.9165015885985459
0.914709628948863
0.9129370832735517
0.9111593356394858
0.9093091340666881
0.9074783464682621
0.9056669728442077
0.9038503972613984
0.9020532356529609
0.9002508720857685
0.8984433065598214
0.8966371348945215
0.893916172900962
0.8914403282371033
0.889209600902946
0.8869131945782439
0.8848619055832435
0.8827449375976983
0.8805622906216091
0.8783972422779955
0.8764773112640836
0.8744917012596269
0.8724404122646263
0.8704067219021014
0.8683073525490325
0.8662255818284395
0.8641614097403224
0.8620925221128454
0.8602687518150699
0.8583793025267499
0.8564241742478855
0.8544866446014973
0.8524834359645648
0.8504978259601083
0.8485298145881277
0.8465570876767874
0.844518681774903
0.8424978745054945
0.8404946658685619
0.8384867416922694
0.8364964161484533
0.834501375065277
0.832501618442741
0.830503125345168
0.8296027895011142
0.8284082033078174
0.826919366765278
0.8255093743661907
0.8238051316178607
0.8221797330129829
0.8206331785515573
0.8190654978655653
0.8172035668303312
0.8154204799385492
0.8137162371902191
0.811990868217323
0.8103443433878795
0.8086766923338697
0.806987915055294
0.8053047985315296
0.8033274316585233
0.8014289089289688
0.7996092303428664
0.797768425532198
0.7960064648649818
0.7942233779731995
0.7924191648568515
0.7906206124953148
0.7889009042772307
0.7871600698345804
0.7853981091673641
0.7836418092549592
0.7818643831179888
0.7800926177358295
0.7783265131084821
0.7765588916864541
];

figure;
plot(t, y_fig_4_13_s6_p34);
xlim([0 1023]);
title('Fig. 4.13, S6, CDF(4,4), p. 34');
