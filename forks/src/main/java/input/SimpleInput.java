package input;

import java.util.HashMap;

public class SimpleInput implements InputInterface{

	@Override
	public String getS() {
	
		//return "((A,B)!H1,C)!H0";
		
		//ok
	
		// 1) return "((A,B)!H1,C)!H0";
		
		// 2) return "((A,B)!H1,C)!H0";
		
		// 3) return "((A,B)!H1,C)!H0";
		
		// 4) return "((D,((A,B)!H4,(C,F)!H7)!H3)!H1,E)!H0";
		
		//AS
		//return "((((Chipping_Sparrow,(((Y_headed_Blackbird,Brewer_Blackbird)!H7,Bullock_Oriole)!H6,(Y_rumped_Warbler,Grace_Warbler)!H11)!H5)!H3,(Indigo_Bunting,B_headed_Grosbeak)!H14)!H2,((American_Robin,Western_Bluebird)!H18,((Brown_Creeper,Bg_Gnatcatcher)!H22,W_breasted_Nuthatch)!H21)!H17)!H1,(((Western_Kingbird,Scissor_tailed_Flycatcher)!H28,(Ash_throated_Flycatcher,Great_crested_Flycatcher)!H31)!H27,(Gray_Flycatcher,Hammond_Flycatcher)!H34)!H26)!H0";
				
		//CA
		//return "(((c_muricata,((((((c_lachenalii,c_heleonastes)!H9,c_brunnescens)!H8,c_chordorrhiza)!H7,(c_arenaria,(c_dioica,(c_parallela,c_davalliana)!H18)!H16)!H14)!H6,c_paniculata)!H5,c_echinata)!H4)!H2,((((((((((((c_hirta,(c_riparia,c_lasiocarpa)!H36)!H34,(c_rostrata,c_vesicaria)!H39)!H33,(c_magellanica,c_limosa)!H42)!H32,(c_elata,c_bigelowii)!H45)!H31,c_globularis)!H30,c_capillaris)!H29,c_hostiana)!H28,c_atrofusca)!H27,(c_digitata,c_ornithopoda)!H52)!H26,(c_meadii,c_panicea)!H55)!H25,((c_flacca,c_ferruginea)!H59,(c_firma,c_sempervirens)!H62)!H58)!H24,(c_alba,(c_buxbaumii,(c_pilulifera,c_glacialis)!H69)!H67)!H65)!H23)!H1,(((c_rupestris,u_rubra)!H74,k_myosuroides)!H73,(c_baldensis,c_curvula)!H78)!H72)!H0";
		
		//COG2085
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";

		//COG3715
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";
		
		//COG4964
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";
		
		//COG4965
		//return "((((273075,((224325,(64091,188937)!H8)!H6,((243232,(190192,187420)!H14)!H12,186497)!H11)!H5)!H3,(228908,((272557,2287)!H21,13773)!H20)!H18)!H2,(184922,((5833,237895)!H28,(3702,(4932,(6239,(7227,(7955,((9606,9598)!H42,10090)!H41)!H39)!H37)!H35)!H33)!H31)!H27)!H25)!H1,(((273068,212717)!H48,((262768,(243273,233150)!H54)!H52,((93061,(272626,((260799,224308)!H63,221109)!H62)!H60)!H58,(220668,(226185,(272623,170187)!H71)!H69)!H67)!H57)!H51)!H47,(((((882,(959,243231)!H80)!H78,(234267,204669)!H83)!H77,(((273121,(85962,235279)!H90)!H88,192222)!H87,(((66077,272947)!H96,(190650,((258594,224911)!H102,((266835,235)!H106,(266834,176299)!H109)!H105)!H101)!H99)!H95,((228410,((520,267608)!H116,(243365,122586)!H119)!H115)!H113,(227377,((190485,160492)!H125,(208964,(211586,((74109,243277)!H133,(71421,(((209261,(83333,198214)!H142)!H140,187410)!H139,(36870,107806)!H146)!H138)!H136)!H132)!H130)!H128)!H124)!H122)!H112)!H94)!H86)!H76,(((243274,224324)!H151,190304)!H150,(((262724,243230)!H157,243164)!H156,(251221,(((84588,74547)!H165,167539)!H164,(269084,103690)!H169)!H163)!H161)!H155)!H149)!H75,((((242619,226186)!H175,194439)!H174,(272561,115711)!H179)!H173,((((243276,224326)!H185,189518)!H184,117)!H183,((206672,203267)!H191,((83331,196627)!H195,100226)!H194)!H190)!H182)!H172)!H74)!H46)!H0";
		
		//CP
		//return "(Tylochromis_intermedius,(((Oreochromis_niloticus,Sarotherodon_galilaeus)!H4,Tilapia_guineensis)!H3,(Hemichromis_fasciatus,Hemichromis_letourneuxi)!H8)!H2)!H0";
		
		//CT
		//return "(A_burtoni,((T_duboisi,(T_moorii,T_brichardi)!H5)!H3,((((P_famula,(P_fasciolatus,I_loocki)!H13)!H11,(PT_ephippium,(P_polyodon,P_macrognathus)!H18)!H16)!H10,((((G_pfefferi,C_horei)!H24,(P_curvifrons,(P_marginatus,(SP_babaulti,NP_babaulti)!H31)!H29)!H27)!H23,L_dardenni)!H22,S_diagramma)!H21)!H9,L_labiatus)!H8)!H2)!H0";
		
		//EC
		//return "(h006,((h005,h004)!H3,((h003,h002)!H7,(h001,h000)!H10)!H6)!H2)!H0";
		
		//FA
		//return "(((((Elisabethiella,Alfonsiella)!H4,Allotriozoon)!H3,Nigeriella)!H2,Courtella)!H1,(Ceratosolen,Platyscapa)!H10)!H0"; 
		
		//FD
		//return "((((h019,h018)!H3,h015)!H2,((((h016,((((h014,h013)!H15,((h008,h010)!H19,h009)!H18)!H14,((h007,h006)!H24,(h012,h005)!H27)!H23)!H13,(h017,h011)!H30)!H12)!H10,h000)!H9,h003)!H8,(h002,h001)!H35)!H7)!H1,h004)!H0";
		
		//FE
		//return "((((Formicinae,Myrmicinae)!H3,Ectatomminae)!H2,Myrmeciinae)!H1,Ponerinae)!H0";
		
		//GL
		//return "((h000,h001)!H1,(h002,(h003,(h004,(h005,(h006,h007)!H12)!H10)!H8)!H6)!H4)!H0";
		
		//GM
		//return "(((((((Allotoca_meeki,Allotoca_diazi)!H6,Allotoca_zacapuensis)!H5,Allotoca_duguesi)!H4,Neoophorus_regalis)!H3,((Zoogoneticus_purhepechus,Zoogoneticus_quitzeoensis)!H13,(Alloophorus_robustus,Chapalicthys_pardalis)!H16)!H12)!H2,(((Ilyodon_whitei,Ilyodon_furcidens)!H21,Xenotaenia_resolanae)!H20,Allodontichthys_zonistius)!H19)!H1,Characodon_audax)!H0";
	
		//IFL
		//return "(Cryptocercus_punctulatus,(((Llaveia_axin_axin_3,(Icerya_purchasi_4,Crypticerya_sp._5)!H6)!H4,Insignorthezia_insignis_23)!H3,(((Rhizoecus_gracilis,Geococcus_coffeae)!H12,(Rastrococcus_asteliae,Rastrococcus_invadens)!H15)!H11,((Parasaissetia_nigra_8,(Ceroplastes_sp._14,Coccus_viridis_24)!H21)!H19,(Cryptococcus_ulmi,(Lecanodiaspis_prosopidis_6,(Aulacaspis_sp._34,(Aonidiella_sp._40,Aonidiella_aurantii)!H30)!H28)!H26)!H24)!H18)!H10)!H2)!H0";
	
		//MF
		//return "(((((a,b)!H4,((i,h)!H8,(c,d)!H11)!H7)!H3,j)!H2,e)!H1,((f,g)!H17,k)!H16)!H0";
	
		//MP
		//return "(Manica,((formosae,(arisana,(ruginodis,rubra)!H7)!H5)!H3,((schencki,(sulcinodis,lobicornis)!H13)!H11,(rugulosa,((specioides,hellenica)!H19,(vandeli,(scabrinodis,sabuleti)!H24)!H22)!H18)!H16)!H10)!H2)!H0";
	
		//PML
		//return "(((((((h000,h001)!H6,h002)!H5,((h003,h004)!H11,h005)!H10)!H4,h006)!H3,(h007,((h008,h009)!H19,(((h010,h011)!H24,h012)!H23,h013)!H22)!H18)!H16)!H2,(h014,h015)!H29)!H1,(h016,h017)!H32)!H0";

		//PMP
		//return "((((h000,(h001,(h002,(h004,(h003,(h005,h006)!H13)!H11)!H9)!H7)!H5)!H3,(h007,((h008,h009)!H19,(((h010,h011)!H24,h012)!H23,h013)!H22)!H18)!H16)!H2,(h014,h015)!H29)!H1,(h016,h017)!H32)!H0";
	
		//PP
		//return "((((((h035,(h033,(h034,h032)!H9)!H7)!H5,(h031,h030)!H12)!H4,(h029,(h028,h027)!H17)!H15)!H3,((h026,h025)!H21,(h024,(h022,(h023,h021)!H28)!H26)!H24)!H20)!H2,((((h019,(h020,h018)!H36)!H34,(h016,(h017,h015)!H41)!H39)!H33,(h014,(h013,h012)!H46)!H44)!H32,(h011,(h010,(h009,h008)!H53)!H51)!H49)!H31)!H1,((((h007,h006)!H59,(h005,(h004,h003)!H64)!H62)!H58,(h001,h000)!H67)!H57,h002)!H56)!H0";

		//RH
		//return "(((((((h005,(h003,h004)!H8)!H6,(h013,h014)!H11)!H5,(h009,((h006,h012)!H17,(h008,(h001,((h002,h007)!H25,h000)!H24)!H22)!H20)!H16)!H14)!H4,((h018,h019)!H30,((h020,(h021,h022)!H36)!H34,h017)!H33)!H29)!H3,((h011,h010)!H41,(h015,h016)!H44)!H40)!H2,((h023,h024)!H48,((h025,h033)!H52,h026)!H51)!H47)!H1,((h032,h031)!H57,((h027,h028)!H61,(h029,h030)!H64)!H60)!H56)!H0";
		
		//RM
		//return "((R_tucanus,((R_vitellinus,R_ariel_SEBrazil)!H4,R_sulfuratus)!H3)!H1,P_inscriptus)!H0";
		
		//RP
		//return "((h000,(h001,h002)!H3)!H1,(h005,((((((h003,h006)!H13,h004)!H12,h007)!H11,h008)!H10,h012)!H9,(h009,(h010,h011)!H22)!H20)!H8)!H6)!H0";
		
		//SBL
		//return "(Spotted_Shag,((Adelie_Penguin,(Little_Blue_Penguin,(Fiordland_Crested_Penguin,Yellow-eyed_Penguin)!H7)!H5)!H3,((Royal_Albatros,Buller_Mollymawk)!H11,(((Mottled_Petrel,Cook_Petrel)!H16,(Westland_Petrel,(Sooty_Shearwather,Hutton_Shearwater)!H21)!H19)!H15,((Broad-billed_Prion,Fairy_Prion)!H25,Common_Diving_Petrel)!H24)!H14)!H10)!H2)!H0";
	
		//SC
		//return "(h000,(((h001,h002)!H4,h003)!H3,((h008,h009)!H9,((((h006,h004)!H15,h005)!H14,h007)!H13,h010)!H12)!H8)!H2)!H0";
		
		//SFC
		return "(h014,((((h008,(h009,h001)!H7)!H5,((h006,h005)!H11,((h000,h004)!H15,h002)!H14)!H10)!H4,(h003,h007)!H19)!H3,((h012,h013)!H23,(h011,h010)!H26)!H22)!H2)!H0";
		
	}
	
	@Override
	public String getG() {
		//return "((A,C)!H1,B)!H0";
		
		//ok
		
		// 1) return "((((((((B3,A3)!P7,C3)!P6,C2)!P5,B2)!P4,A2)!P3,A1)!P2,(((A0,B0)!P17,C0)!P16,C1)!P15)!P1,B1)!P0";
		
		// 2) return "((((((((B3,A3)!P7,C3)!P6,C2)!P5,B2)!P4,A2)!P3,A1)!P2,B1)!P1,(((A0,B0)!P18,C0)!P17,C1)!P16)!P0";
		
		// 3) return "(((((((B3,A3)!P6,C3)!P5,C2)!P4,B2)!P3,A2)!P2,((((A0,B0)!P16,C0)!P15,C1)!P14,B1)!P13)!P1,A1)!P0";
		
		// 4) return "(B0,(A0,((F0,E0)!P5,(D0,C0)!P8)!P4)!P2)!P0";
		
		//AS
		//return "((((((((S_sittae,S_polioptilus)!P7,S_certhiae)!P6,S_dendroicae_A)!P5,S_dendroicae_B)!P4,S_sp_D)!P3,(S_sp_F,(S_sp_E,S_elongatus)!P16)!P14)!P2,(S_passerinae,(S_sp_C,(S_tyranni_A,S_tyranni_B)!P23)!P21)!P19)!P1,(S_empidonax,(S_turdus,S_sialiae)!P28)!P26)!P0";
		
		//CA
		//return "(((((((a_karii,(a_turfusa,(a_bigelowii,a_pratensis)!P10)!P8)!P6,((((a_hostianae,a_buxbaumii)!P16,a_lasiocarpae)!P15,a_caricis-meadii)!P14,a_paniceae)!P13)!P5,a_misandrae)!P4,(((a_inclusa,a_subinclusa)!P25,a_heterospora)!P24,a_sempervirentis)!P23)!P3,a_limosa)!P2,((a_aspera,a_arenaria)!P49,a_sp1)!P48)!P1,((a_elynae,a_curvulae)!P54,a_sclerotiformis)!P53)!P0";
	
		//COG2085
		//return "((((9598.01,9606.01)!P3,10090.02)!P2,((7955.02,7955.01)!P8,(10090.01,(((100226.06,(((188937.01,(224325.02,224325.01)!P21)!P19,64091.01)!P18,(187420.01,(190192.01,243232.01)!P27)!P25)!P17)!P15,251221.01)!P14,((((272623.01,(220668.03,196627.02)!P36)!P34,(100226.05,100226.04)!P39)!P33,267608.01)!P32,((((204669.01,189518.01)!P46,103690.01)!P45,234267.02)!P44,(((160492.01,266835.03)!P53,100226.03)!P52,((220668.02,196627.01)!P58,((((100226.02,190485.01)!P64,266835.02)!P63,100226.01)!P62,(220668.01,(176299.01,(266834.01,(266835.01,(234267.01,224911.01)!P77)!P75)!P73)!P71)!P69)!P61)!P57)!P51)!P43)!P31)!P13)!P11)!P7)!P1,(7955.03,((9606.02,9598.02)!P83,10090.03)!P82)!P80)!P0";

	
		//COG3715
		//return "((221109.01,(((272626.03,226185.13)!P5,170187.04)!P4,(272623.01,((((187410.02,(209261.02,(83333.02,198214.04)!P18)!P16)!P14,272626.04)!P13,(198214.03,224308.01)!P22)!P12,(170187.03,(((((273068.01,226185.12)!P31,(226185.11,209261.01)!P34)!P30,226185.10)!P29,(226185.09,(272626.02,(((170187.02,226185.08)!P44,226185.07)!P43,226185.06)!P42)!P40)!P38)!P28,((((226185.05,(190304.01,226185.04)!P54)!P52,272626.01)!P51,226185.03)!P50,((74109.02,187410.01)!P60,(((74109.01,198214.02)!P65,226185.02)!P64,((226185.01,170187.01)!P70,(220668.01,(198214.01,83333.01)!P75)!P73)!P69)!P63)!P59)!P49)!P27)!P25)!P11)!P9)!P3)!P1,220668.02)!P0";
	
		//COG4964
		//return "(((((266834.02,176299.01)!P4,266835.03)!P3,((224911.03,224911.02)!P9,258594.01)!P8)!P2,((74109.01,(266835.04,224911.04)!P16)!P14,((266835.02,((266834.01,266835.01)!P23,224911.01)!P22)!P20,((882.01,(194439.01,267608.02)!P30)!P28,(((520.02,267608.01)!P35,208964.01)!P34,((959.01,(234267.02,234267.01)!P42)!P40,(520.01,(117.01,(243230.01,262724.01)!P49)!P47)!P45)!P39)!P33)!P27)!P19)!P13)!P1,190650.01)!P0";
	
		//COG4965
		//return "((266834.01,(190650.01,((224911.01,117.02)!P6,(((882.01,((234267.02,234267.01)!P14,194439.01)!P13)!P11,74109.02)!P10,(((117.03,267608.02)!P21,234267.03)!P20,((266835.02,266835.01)!P26,((((959.01,117.01)!P32,520.02)!P31,100226.01)!P30,(((74109.01,187410.01)!P39,(83331.01,196627.01)!P42)!P38,(208964.01,(520.01,267608.01)!P47)!P45)!P37)!P29)!P25)!P19)!P9)!P5)!P3)!P1,(((266834.02,176299.01)!P52,266835.03)!P51,(258594.01,224911.02)!P56)!P50)!P0";
		
		//CP
		//return "(((((((Cichlidogyrus_halli2,Cichlidogyrus_halli1)!P6,((Cichlidogyrus_tiberianus,Cichlidogyrus_cubitus)!P10,((Cichlidogyrus_douellouae,Cichlidogyrus_ergensi)!P14,((((Cichlidogyrus_agnesi,Cichlidogyrus_gallus)!P20,Cichlidogyrus_flexicolpos)!P19,(Cichlidogyrus_thurstonae,Cichlidogyrus_bilongi)!P24)!P18,Cichlidogyrus_aegypticus)!P17)!P13)!P9)!P5,(((Cichlidogyrus_cirratus,Cichlidogyrus_njinei)!P30,(Cichlidogyrus_acerbus,Cichlidogyrus_sp2)!P33)!P29,(((Cichlidogyrus_digitatus,Cichlidogyrus_arthracanthus)!P38,Cichlidogyrus_yanni)!P37,(((Scutogyrus_longicornis,Scutogyrus_bailloni)!P44,Scutogyrus_minus)!P43,Cichlidogyrus_tilapiae)!P42)!P36)!P28)!P4,((Cichlidogyrus_longicirrus,Cichlidogyrus_sp1)!P50,Cichlidogyrus_falcifer)!P49)!P3,Cichlidogyrus_amphoratus)!P2,Cichlidogyrus_sclerosus)!P1,Cichlidogyrus_pouyaudi)!P0";
		
		//CT
		//return "((((((P_fasciolatus-001,I_loocki-001)!P5,(P_polyodon-003,P_macrognathus-002)!P8)!P4,PT_ephippium-001)!P3,(((((L_dardenni-001,S_diagramma-001)!P16,G_pfefferi-001)!P15,(SP_babaulti-001,(C_horei-001,(P_curvifrons-001,(NP_babaulti-001,P_marginatus-001)!P26)!P24)!P22)!P20)!P14,((T_duboisi-001,T_brichardi-001)!P30,T_moorii-001)!P29)!P13,L_labiatus-001)!P12)!P2,P_famula-001)!P1,A_burtoni-001)!P0";
	
		//EC
		//return "((((h000-001,(((h000-002,h001-002)!P7,h001-001)!P6,(h002-002,(h002-001,h003-001)!P13)!P11)!P5)!P3,h004-001)!P2,h005-001)!P1,h006-001)!P0";
		
		//FA
		//return "((((Chlamydodorae1,Platyphylla)!P3,Caulocarpae)!P2,((Chlamydodorae2,Crassicostae)!P8,Galoglychia)!P7)!P1,(Sycomorus,Urostigma)!P12)!P0"; 
		
		//FD
		//return "((((h000-001,(h001-001,h002-001)!P5)!P3,h003-001)!P2,((h004-002,h004-001)!P10,(((((h005-003,h006-001)!P17,h007-001)!P16,((((h008-002,(h009-005,h009-003)!P26)!P24,(h010-002,h010-003)!P29)!P23,(((h008-005,h011-001)!P34,(h012-002,(h012-001,h012-003)!P39)!P37)!P33,(((((h013-001,(h013-004,h013-003)!P48)!P46,(h008-003,(h014-002,(h014-001,h014-003)!P55)!P53)!P51)!P45,(h008-001,h008-004)!P58)!P44,h015-001)!P43,(h015-003,h015-002)!P62)!P42)!P32)!P22,(h016-001,h007-002)!P65)!P21)!P15,(h017-001,(h005-001,((h009-006,h005-002)!P73,(h011-002,h009-002)!P76)!P72)!P70)!P68)!P14,(h010-001,(h009-001,(h013-002,h009-004)!P83)!P81)!P79)!P13)!P9)!P1,(((h018-006,h018-005)!P88,(h018-003,h018-001)!P91)!P87,((h018-004,h018-002)!P95,(h019-001,h019-002)!P98)!P94)!P86)!P0";
	
		//FE
		//return "((((formicine_parasitoids,PEM_parasitoids)!P3,Psilocharitini)!P2,Oraseminae)!P1,Gollumiellinae)!P0";
		
		//GL
		//return "((h000-002,h001-002)!P1,((h000-001,(h001-001,h002-001)!P7)!P5,(h003-001,((h004-001,h005-001)!P13,(h006-001,h007-001)!P16)!P12)!P10)!P4)!P0";
	
		//GM
		//return "((((((((La_Luz_Spring,Mintzita_Spring)!P7,Rico_Spring)!P6,Chapultepec_Spring)!P5,Zacapu_Lake)!P4,Opopeo_Lake)!P3,(((Abraham_Gonzalez_Spring,Guadalupe_Aguilera_Spring)!P16,El_Toboso_Spring)!P15,Pino_Suarez_Spring)!P14)!P2,((Tlapetlahuaya_Spring,Tocumbo_Spring)!P22,Ahuacapan_Spring)!P21)!P1,Margotrema_resolanae)!P0";
		
		//IFL
		//return "((((F_Aonidiella_sp._40,F_Aonidiella_aurantii)!P3,F_Aulacaspis_sp._34)!P2,((F_Rastrococcus_asteliae,F_Rastrococcus_invadens)!P8,(F_Cryptococcus_ulmi,((F_Ceroplastes_sp._14,F_Coccus_viridis_24)!P14,(F_Insignorthezia_insignis_23,(F_Parasaissetia_nigra_8,(F_Lecanodiaspis_prosopidis_6,((F_Icerya_purchasi_4,F_Crypticerya_sp._5)!P24,F_Llaveia_axin_axin_3)!P23)!P21)!P19)!P17)!P13)!P11)!P7)!P1,((F_Rhizoecus_gracilis,F_Geococcus_coffeae)!P29,F_Cryptocercus_punctulatus)!P28)!P0";
		
		//MF
		//return "((((1,3)!P3,2)!P2,(4,5)!P7)!P1,((7,8)!P11,(6,9)!P14)!P10)!P0";
		
		//MP
		//return "(Phengaris_daitozana,(Phengaris_atroguttata,((alcon,rebeli)!P5,((arion,arionides)!P9,(teleius,nausithous)!P12)!P8)!P4)!P2)!P0";
		
		//PML
		//return "((((h000-001,(h001-001,((h002-001,h003-001)!P8,(h004-001,h005-001)!P11)!P7)!P5)!P3,(h006-001,h007-001)!P14)!P2,((h008-001,h009-001)!P18,((h010-001,(h011-001,(h012-001,h013-001)!P26)!P24)!P22,(h014-001,h015-001)!P29)!P21)!P17)!P1,(h016-001,h017-001)!P32)!P0";
	
		//PMP
		//return "((((((h000-001,(h001-001,((h002-001,h003-001)!P10,(h004-001,(h005-001,h006-001)!P15)!P13)!P9)!P7)!P5,h007-001)!P4,(h008-001,h009-001)!P19)!P3,(h010-001,(h011-001,(h012-001,h013-001)!P26)!P24)!P22)!P2,(h014-001,h015-001)!P29)!P1,(h016-001,h017-001)!P32)!P0";
		
		//PP
		//return "(((h000-001,h001-001)!P2,(h002-001,(((((h003-002,h003-001)!P11,h004-001)!P10,h005-001)!P9,h006-001)!P8,h007-001)!P7)!P5)!P1,(((((h008-002,h008-001)!P22,h009-001)!P21,(h010-001,(h011-001,(h012-001,(h013-001,h014-001)!P32)!P30)!P28)!P26)!P20,((((h015-001,h016-002)!P38,h016-001)!P37,h017-001)!P36,((((h018-001,h018-002)!P46,h019-001)!P45,h020-002)!P44,h020-001)!P43)!P35)!P19,(((((((h021-001,h022-001)!P58,h023-001)!P57,h024-001)!P56,(h025-001,h026-001)!P63)!P55,(h027-001,h028-001)!P66)!P54,h029-001)!P53,((h030-001,h031-001)!P71,(h032-001,(h033-001,(h034-001,h035-001)!P78)!P76)!P74)!P70)!P52)!P18)!P0";
	
		//RH
		//return "((((((((((h000-002,h000-001)!P9,((h001-002,h001-001)!P13,h002-001)!P12)!P8,((h003-001,h004-001)!P18,h005-001)!P17)!P7,(((h006-001,h007-001)!P24,h008-001)!P23,h009-001)!P22)!P6,((h010-001,(h010-002,(h011-002,h011-001)!P34)!P32)!P30,h010-003)!P29)!P5,((h012-001,h013-002)!P39,h013-001)!P38)!P4,(h014-001,(h015-001,h016-001)!P45)!P43)!P3,((h017-001,(h018-001,h019-001)!P51)!P49,(h020-001,(h021-001,h022-001)!P56)!P54)!P48)!P2,((((h023-001,h024-004)!P62,(h024-002,(h024-001,h024-003)!P67)!P65)!P61,(h025-001,h026-001)!P70)!P60,((((h027-001,h028-001)!P76,h029-001)!P75,h030-001)!P74,h031-001)!P73)!P59)!P1,h032-001)!P0";
	
		//RM
		//return "((((A_cancellosus4,A_cancellosus5)!P3,A_cancellosus6)!P2,A_cancellosus1)!P1,A_cancellosus3)!P0";
	
		//RP
		//return "((((h000-001,(h001-001,h002-001)!P5)!P3,h003-001)!P2,h004-001)!P1,(h005-001,(((((h006-001,h007-001)!P16,h008-001)!P15,(h009-001,h010-001)!P20)!P14,h011-001)!P13,h012-001)!P12)!P10)!P0";
	
		//SBL
		//return "(Pectinopygus,(Docophoroides,((Austrogonoides,Episbates)!P5,(((Naubates,Harrisoniella)!P10,Pelmatocerandra)!P9,Trabeculus)!P8)!P4)!P2)!P0";
	
		//SC
		//return "(h000-001,(((h001-001,h002-001)!P4,h003-001)!P3,(((h004-001,h005-001)!P10,(h006-002,h007-002)!P13)!P9,(h008-001,(((h009-001,(h006-001,h004-002)!P22)!P20,h010-001)!P19,h007-001)!P18)!P16)!P8)!P2)!P0";
	
		//SFC
		return "(h000-001,(h001-001,((h002-002,h003-001)!P5,((h004-001,(((h005-001,h006-001)!P13,(h007-001,(h008-001,h002-001)!P18)!P16)!P12,h009-001)!P11)!P9,((((h010-001,h011-001)!P25,h012-001)!P24,h013-001)!P23,h014-001)!P22)!P8)!P4)!P2)!P0";
	
	
	}


	

	@Override
	public HashMap<String, String> getMapping() {
		String mapping="";
		
		//AS
		//mapping=" S_certhiae=Brown_Creeper, S_sp_C=B_headed_Grosbeak, S_turdus=American_Robin, S_dendroicae_B=Grace_Warbler, S_dendroicae_A=Grace_Warbler, S_tyranni_B=Ash_throated_Flycatcher, S_empidonax=Gray_Flycatcher, S_sp_D=Chipping_Sparrow, S_polioptilus=Bg_Gnatcatcher, S_sittae=W_breasted_Nuthatch, S_elongatus=Brewer_Blackbird, S_sialiae=Western_Bluebird, S_sp_F=Bullock_Oriole, S_sp_E=Y_headed_Blackbird, S_tyranni_A=Western_Kingbird, S_passerinae=Indigo_Bunting";
		
		//CA
		//mapping=" a_bigelowii=c_bigelowii, a_inclusa=c_rostrata, a_elynae=k_myosuroides, a_sp1=c_davalliana, a_limosa=c_limosa, a_hostianae=c_hostiana, a_pratensis=c_flacca, a_curvulae=c_curvula, a_heterospora=c_elata, a_sempervirentis=c_ferruginea, a_buxbaumii=c_buxbaumii, a_turfusa=c_heleonastes, a_karii=c_echinata, a_paniceae=c_meadii, a_aspera=c_chordorrhiza, a_lasiocarpae=c_lasiocarpa, a_arenaria=c_arenaria, a_caricis-meadii=c_panicea, a_subinclusa=c_vesicaria, a_sclerotiformis=u_rubra, a_misandrae=c_atrofusca";
		
		//COG2085
		//mapping=" 10090.02=10090, 64091.01=64091, 100226.03=100226, 196627.02=196627, 266834.01=266834, 224911.01=224911, 251221.01=251221, 190485.01=190485, 204669.01=204669, 100226.01=100226, 100226.04=100226, 220668.01=220668, 234267.01=234267, 176299.01=176299, 10090.01=10090, 9598.01=9598, 196627.01=196627, 103690.01=103690, 7955.03=7955, 10090.03=10090, 220668.03=220668, 9598.02=9598, 188937.01=188937, 267608.01=267608, 100226.02=100226, 100226.05=100226, 266835.03=266835, 7955.01=7955, 9606.02=9606, 7955.02=7955, 190192.01=190192, 243232.01=243232, 160492.01=160492, 9606.01=9606, 189518.01=189518, 224325.02=224325, 272623.01=272623, 100226.06=100226, 234267.02=234267, 266835.02=266835, 266835.01=266835, 187420.01=187420, 220668.02=220668, 224325.01=224325";
		
		//COG3715
		//mapping=" 226185.13=226185, 198214.03=198214, 272626.01=272626, 226185.10=226185, 220668.01=220668, 220668.02=220668, 226185.12=226185, 74109.01=74109, 226185.08=226185, 226185.02=226185, 272626.02=272626, 226185.01=226185, 83333.01=83333, 170187.01=170187, 187410.02=187410, 221109.01=221109, 74109.02=74109, 226185.06=226185, 209261.01=209261, 83333.02=83333, 170187.02=170187, 187410.01=187410, 226185.09=226185, 226185.04=226185, 272623.01=272623, 170187.04=170187, 170187.03=170187, 273068.01=273068, 190304.01=190304, 272626.03=272626, 226185.07=226185, 198214.04=198214, 226185.11=226185, 209261.02=209261, 226185.05=226185, 198214.02=198214, 198214.01=198214, 224308.01=224308, 226185.03=226185, 272626.04=272626";

		//COG4964
		//mapping=" 266835.03=266835, 266834.01=266834, 267608.01=267608, 194439.01=194439, 234267.01=234267, 959.01=959, 258594.01=258594, 266834.02=266834, 117.01=117, 520.02=520, 266835.04=266835, 234267.02=234267, 208964.01=208964, 190650.01=190650, 224911.02=224911, 224911.03=224911, 224911.01=224911, 882.01=882, 262724.01=262724, 176299.01=176299, 520.01=520, 224911.04=224911, 267608.02=267608, 74109.01=74109, 243230.01=243230, 266835.01=266835, 266835.02=266835";
		
		//COG4965
		//mapping=" 224911.01=224911, 267608.02=267608, 266835.03=266835, 100226.01=100226, 959.01=959, 196627.01=196627, 187410.01=187410, 234267.02=234267, 266834.01=266834, 224911.02=224911, 520.01=520, 520.02=520, 194439.01=194439, 83331.01=83331, 74109.01=74109, 176299.01=176299, 882.01=882, 117.02=117, 266835.02=266835, 266835.01=266835, 266834.02=266834, 190650.01=190650, 208964.01=208964, 74109.02=74109, 117.01=117, 234267.01=234267, 267608.01=267608, 234267.03=234267, 258594.01=258594, 117.03=117";
		
		//CP
		//mapping=" Cichlidogyrus_tiberianus=Tilapia_guineensis, Cichlidogyrus_bilongi=Tilapia_guineensis, Cichlidogyrus_sclerosus=Oreochromis_niloticus, Cichlidogyrus_arthracanthus=Tilapia_guineensis, Cichlidogyrus_acerbus=Sarotherodon_galilaeus, Scutogyrus_minus=Oreochromis_niloticus, Scutogyrus_longicornis=Oreochromis_niloticus, Cichlidogyrus_ergensi=Tilapia_guineensis, Cichlidogyrus_halli2=Oreochromis_niloticus, Cichlidogyrus_longicirrus=Hemichromis_fasciatus, Cichlidogyrus_digitatus=Tilapia_guineensis, Cichlidogyrus_gallus=Tilapia_guineensis, Scutogyrus_bailloni=Sarotherodon_galilaeus, Cichlidogyrus_yanni=Tilapia_guineensis, Cichlidogyrus_amphoratus=Tilapia_guineensis, Cichlidogyrus_douellouae=Sarotherodon_galilaeus, Cichlidogyrus_cubitus=Tilapia_guineensis, Cichlidogyrus_cirratus=Oreochromis_niloticus, Cichlidogyrus_njinei=Sarotherodon_galilaeus, Cichlidogyrus_falcifer=Hemichromis_fasciatus, Cichlidogyrus_halli1=Sarotherodon_galilaeus, Cichlidogyrus_tilapiae=Oreochromis_niloticus, Cichlidogyrus_flexicolpos=Tilapia_guineensis, Cichlidogyrus_sp2=Sarotherodon_galilaeus, Cichlidogyrus_agnesi=Tilapia_guineensis, Cichlidogyrus_sp1=Hemichromis_letourneuxi, Cichlidogyrus_aegypticus=Tilapia_guineensis, Cichlidogyrus_pouyaudi=Tylochromis_intermedius, Cichlidogyrus_thurstonae=Oreochromis_niloticus";
		
		
		//CT
		//mapping=" P_polyodon-003=P_polyodon, P_curvifrons-001=P_curvifrons, A_burtoni-001=A_burtoni, P_famula-001=P_famula, T_brichardi-001=T_brichardi, PT_ephippium-001=PT_ephippium, P_macrognathus-002=P_macrognathus, P_marginatus-001=P_marginatus, T_duboisi-001=T_duboisi, L_dardenni-001=L_dardenni, I_loocki-001=I_loocki, P_fasciolatus-001=P_fasciolatus, SP_babaulti-001=SP_babaulti, T_moorii-001=T_moorii, S_diagramma-001=S_diagramma, L_labiatus-001=L_labiatus, G_pfefferi-001=G_pfefferi, NP_babaulti-001=NP_babaulti, C_horei-001=C_horei";
		
		//EC
		//mapping=" h002-001=h002, h000-002=h000, h001-002=h001, h000-001=h000, h005-001=h005, h003-001=h003, h002-002=h002, h001-001=h001, h004-001=h004, h006-001=h006";
		
		//FA
		//mapping=" Galoglychia=Allotriozoon, Platyphylla=Nigeriella, Caulocarpae=Courtella, Chlamydodorae1=Alfonsiella, Sycomorus=Ceratosolen, Crassicostae=Elisabethiella, Chlamydodorae2=Elisabethiella, Urostigma=Platyscapa";
		
		//FD
		//mapping=" h002-001=h002, h009-005=h009, h012-001=h012, h005-002=h005, h010-001=h010, h016-001=h016, h013-003=h013, h013-001=h013, h009-002=h009, h009-006=h009, h004-001=h004, h000-001=h000, h015-003=h015, h018-006=h018, h012-002=h012, h006-001=h006, h015-002=h015, h018-004=h018, h012-003=h012, h008-001=h008, h004-002=h004, h013-002=h013, h010-002=h010, h014-003=h014, h008-003=h008, h007-001=h007, h011-001=h011, h005-003=h005, h008-004=h008, h008-005=h008, h017-001=h017, h005-001=h005, h018-003=h018, h014-002=h014, h009-001=h009, h009-004=h009, h013-004=h013, h019-002=h019, h018-005=h018, h003-001=h003, h010-003=h010, h001-001=h001, h018-001=h018, h019-001=h019, h018-002=h018, h014-001=h014, h007-002=h007, h011-002=h011, h009-003=h009, h015-001=h015, h008-002=h008";
		
		//FE
		//mapping=" PEM_parasitoids=Ectatomminae, Psilocharitini=Ponerinae, formicine_parasitoids=Formicinae, Gollumiellinae=Formicinae, Oraseminae=Myrmeciinae";
		
		//GL
		//mapping=" h003-001=h003, h001-002=h001, h000-001=h000, h000-002=h000, h006-001=h006, h004-001=h004, h002-001=h002, h001-001=h001, h005-001=h005, h007-001=h007";
		
		//GM
		//mapping=" Rico_Spring=Neoophorus_regalis, Tlapetlahuaya_Spring=Ilyodon_whitei, Zacapu_Lake=Allotoca_zacapuensis, Chapultepec_Spring=Allotoca_diazi, Ahuacapan_Spring=Allodontichthys_zonistius, Margotrema_resolanae=Xenotaenia_resolanae, Opopeo_Lake=Allotoca_meeki, Mintzita_Spring=Zoogoneticus_quitzeoensis, La_Luz_Spring=Zoogoneticus_purhepechus, El_Toboso_Spring=Characodon_audax, Abraham_Gonzalez_Spring=Characodon_audax, Guadalupe_Aguilera_Spring=Characodon_audax, Tocumbo_Spring=Chapalicthys_pardalis, Pino_Suarez_Spring=Characodon_audax";
		
		//IFL
		//mapping=" F_Aulacaspis_sp._34=Aulacaspis_sp._34, F_Lecanodiaspis_prosopidis_6=Lecanodiaspis_prosopidis_6, F_Rhizoecus_gracilis=Rhizoecus_gracilis, F_Rastrococcus_invadens=Rastrococcus_invadens, F_Rastrococcus_asteliae=Rastrococcus_asteliae, F_Crypticerya_sp._5=Crypticerya_sp._5, F_Llaveia_axin_axin_3=Llaveia_axin_axin_3, F_Cryptococcus_ulmi=Cryptococcus_ulmi, F_Aonidiella_aurantii=Aonidiella_aurantii, F_Aonidiella_sp._40=Aonidiella_sp._40, F_Insignorthezia_insignis_23=Insignorthezia_insignis_23, F_Geococcus_coffeae=Geococcus_coffeae, F_Ceroplastes_sp._14=Ceroplastes_sp._14, F_Cryptocercus_punctulatus=Cryptocercus_punctulatus, F_Coccus_viridis_24=Coccus_viridis_24, F_Icerya_purchasi_4=Icerya_purchasi_4, F_Parasaissetia_nigra_8=Parasaissetia_nigra_8";
		
		//MF
		//mapping=" 7=g, 3=g, 2=b, 1=g, 9=f, 8=g, 5=c, 4=h, 6=e";
		
		
		//MP
		//mapping=" arionides=rubra, Phengaris_atroguttata=arisana, alcon=ruginodis, Phengaris_daitozana=formosae, teleius=rubra, arion=sabuleti, rebeli=schencki, nausithous=rubra";
		
		//PML
		//mapping=" h002-001=h002, h010-001=h010, h017-001=h017, h014-001=h014, h004-001=h004, h003-001=h003, h012-001=h012, h013-001=h013, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h015-001=h015, h006-001=h006, h016-001=h016, h007-001=h007, h011-001=h011, h009-001=h009";
		
		//PMP
		//mapping=" h002-001=h002, h010-001=h010, h017-001=h017, h014-001=h014, h004-001=h004, h003-001=h003, h012-001=h012, h013-001=h013, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h015-001=h015, h006-001=h006, h016-001=h016, h007-001=h007, h011-001=h011, h009-001=h009";
		
		//PP
		//mapping=" h002-001=h002, h008-001=h008, h022-001=h022, h015-001=h015, h031-001=h031, h034-001=h034, h012-001=h012, h026-001=h026, h018-001=h018, h028-001=h028, h016-001=h016, h029-001=h029, h033-001=h033, h030-001=h030, h004-001=h004, h000-001=h000, h024-001=h024, h019-001=h019, h035-001=h035, h014-001=h014, h006-001=h006, h017-001=h017, h025-001=h025, h016-002=h016, h021-001=h021, h003-001=h003, h003-002=h003, h010-001=h010, h011-001=h011, h020-001=h020, h001-001=h001, h018-002=h018, h007-001=h007, h013-001=h013, h005-001=h005, h020-002=h020, h027-001=h027, h032-001=h032, h009-001=h009, h023-001=h023, h008-002=h008";
		
		//RH
		//mapping=" h001-002=h001, h008-001=h008, h021-001=h021, h012-001=h012, h027-001=h027, h030-001=h030, h011-002=h011, h024-002=h024, h015-001=h015, h024-003=h024, h013-001=h013, h025-001=h025, h029-001=h029, h026-001=h026, h003-001=h003, h000-002=h000, h023-001=h023, h017-001=h017, h031-001=h031, h010-003=h010, h005-001=h005, h014-001=h014, h024-004=h024, h013-002=h013, h020-001=h020, h002-001=h002, h032-001=h032, h001-001=h001, h010-001=h010, h010-002=h010, h019-001=h019, h000-001=h000, h016-001=h016, h006-001=h006, h011-001=h011, h004-001=h004, h018-001=h018, h024-001=h024, h028-001=h028, h009-001=h009, h022-001=h022, h007-001=h007";
		
		//RM
		//mapping= " A_cancellosus5=R_ariel_SEBrazil, A_cancellosus6=R_vitellinus, A_cancellosus4=R_sulfuratus, A_cancellosus3=P_inscriptus, A_cancellosus1=R_tucanus";
		
		//RP
		//mapping=" h002-001=h002, h010-001=h010, h004-001=h004, h003-001=h003, h012-001=h012, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h006-001=h006, h007-001=h007, h011-001=h011, h009-001=h009";
		
		//SBL
		//mapping=" Harrisoniella=Buller_Mollymawk, Docophoroides=Buller_Mollymawk, Austrogonoides=Adelie_Penguin, Pectinopygus=Spotted_Shag, Pelmatocerandra=Common_Diving_Petrel, Naubates=Broad-billed_Prion, Episbates=Royal_Albatros, Trabeculus=Mottled_Petrel";
		
		//SC
		//mapping=" h002-001=h002, h006-001=h006, h004-001=h004, h003-001=h003, h010-001=h010, h007-001=h007, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h006-002=h006, h007-002=h007, h004-002=h004, h009-001=h009";
		
		//SFC
		mapping=" h002-002=h002, h009-001=h009, h013-001=h013, h004-001=h004, h003-001=h003, h011-001=h011, h012-001=h012, h005-001=h005, h001-001=h001, h000-001=h000, h008-001=h008, h014-001=h014, h006-001=h006, h007-001=h007, h010-001=h010, h002-001=h002";
		
		
		
		
		
		
		
		HashMap<String, String> map= new HashMap<>();
		
		String[] commaSplit= mapping.split(",");
		for (String commaEntry: commaSplit) {
			String[] equalSplit= commaEntry.split("=");
			map.put(equalSplit[0].substring(1), equalSplit[1]);
		}
		return map;
	}

	@Override
	public String getUnrootedG() {

		return "(A0,(B0,((F0,E0)!P5,(D0,C0)!P8)!P4)!P2)!P0";
		
		//return "((((L0,(I0,(M0,((E0,F0),(H0,G0))))),(C0,D0)),A0),B0)";
		
		//return "((((L0,((I0,N0),(M0,((E0,F0),(H0,G0))))),(C0,D0)),A0),B0)";
				
	}
	
	@Override
	public boolean hasNext() {
		
		return false;
	}

	
}
