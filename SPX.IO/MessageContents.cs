﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Lidgren.Network;

namespace SPX.IO
{
    [Serializable]
    public class MessageContents
    {
        private const bool DEBUG = false;

        public const int CommandMax = 16;
        public const int PlayerMax = 4;
        public const int ByteCount = 80;

        private const byte TrueByte = (byte)1;
        private const byte FalseByte = (byte)0;

        public Int32 TurnCount;
        public byte MessageType;
        public byte PlayerIndex;
        public byte Command;
        public bool IsActive;
        public Int32 RngSeed;
        public byte PlayerCount;
        public byte[] PlayerOneState = new byte[16];
        public byte[] PlayerTwoState = new byte[16];
        public byte[] PlayerThreeState = new byte[16];
        public byte[] PlayerFourState = new byte[16];

        private MessageContents() { }

        public static MessageContents Empty()
        {
            return new MessageContents();
        }

        public static MessageContents CreatePlayerCount(int playerCount)
        {
            return new MessageContents()
            {
                MessageType = MessageTypes.PLAYER_COUNT,
                PlayerCount = (byte)playerCount
            };
        }

        public static MessageContents Create(byte messageType)
        {
            return new MessageContents()
            {
                MessageType = messageType
            };
        }

        public static MessageContents CreateInit(int playerCount, int rngSeed)
        {
            return new MessageContents()
            {
                MessageType = MessageTypes.CONNECT,
                PlayerCount = (byte)playerCount,
                RngSeed = rngSeed
            };
        }

        public static MessageContents CreateCheckState(int command, int playerIndex)
        {
            return new MessageContents()
            {
                MessageType = MessageTypes.CHECK_STATE,
                Command = (byte)command,
                PlayerIndex = (byte)playerIndex
            };
        }

        public static MessageContents CreateMovement(int command, int playerIndex, bool isActive)
        {
            return new MessageContents()
            {
                MessageType = MessageTypes.MOVEMENT,
                PlayerIndex = (byte)playerIndex,
                Command = (byte)command,
                IsActive = isActive
            };
        }

        public static MessageContents CreatePlayerState(Dictionary<int, Dictionary<int, bool>> playerStatus,Int32 turnCount)
        {
            var result = new MessageContents();
            result.MessageType = MessageTypes.SYNC_STATE;
            result.WritePlayerState(playerStatus);
            result.TurnCount = turnCount;
            result.RngSeed = Environment.TickCount;
            return result;
        }

        public static MessageContents CreateReadyForNextTurn()
        {
            return new MessageContents()
            {
                MessageType = MessageTypes.READY_FOR_NEXT_TURN
            };
        }

        public static MessageContents CreateHeartBeat()
        {
            return new MessageContents()
            {
                MessageType = MessageTypes.HEART_BEAT
            };
        }

        internal void Deserialize(NetIncomingMessage _message)
        {
            MessageType = _message.ReadByte();
            if (DEBUG) Console.WriteLine("Serial, mType: " + MessageType);
            PlayerIndex = _message.ReadByte();
            if (DEBUG) Console.WriteLine("Serial, pIndex: " + PlayerIndex);
            Command = _message.ReadByte();
            if (DEBUG) Console.WriteLine("Serial, command: " + Command); 
            IsActive = _message.ReadBoolean();
            if (DEBUG) Console.WriteLine("Serial, iActive: " + IsActive);
            RngSeed = _message.ReadInt32();
            if (DEBUG) Console.WriteLine("Serial, rngSeed: " + RngSeed);
            PlayerCount = _message.ReadByte();
            if (DEBUG) Console.WriteLine("Serial, pCount: " + PlayerCount);
            PlayerOneState = _message.ReadBytes(16);
            PlayerTwoState = _message.ReadBytes(16);
            PlayerThreeState = _message.ReadBytes(16);
            PlayerFourState = _message.ReadBytes(16);
            TurnCount = _message.ReadInt32();
        }

        internal void Serialize(NetOutgoingMessage _message)
        {
            _message.Write(MessageType);
            if (DEBUG) Console.WriteLine("Serial, mType: " + MessageType);
            _message.Write(PlayerIndex);
            if (DEBUG) Console.WriteLine("Serial, pIndex: " + PlayerIndex);
            _message.Write(Command);
            if (DEBUG) Console.WriteLine("Serial, command: " + Command);
            _message.Write(IsActive);
            if (DEBUG) Console.WriteLine("Serial, iActive: " + IsActive);
            _message.Write(RngSeed);
            if (DEBUG) Console.WriteLine("Serial, rngSeed: " + RngSeed);
            _message.Write(PlayerCount);
            if (DEBUG) Console.WriteLine("Serial, pCount: " + PlayerCount);
            _message.Write(PlayerOneState);
            _message.Write(PlayerTwoState);
            _message.Write(PlayerThreeState);
            _message.Write(PlayerFourState);
            _message.Write(TurnCount);
        }

        public void WritePlayerState(Dictionary<int,Dictionary<int,bool>> state)
        {
            for (int jj = 0; jj < PlayerMax; jj++)
            {
                for (int ii = 0; ii < CommandMax; ii++)
                {
                    switch (jj)
                    {
                        case 0:
                            PlayerOneState[ii] = (state[jj][ii])? TrueByte: FalseByte;
                            break;
                        case 1:
                            PlayerTwoState[ii] = (state[jj][ii]) ? TrueByte : FalseByte;
                            break;
                        case 2:
                            PlayerThreeState[ii] = (state[jj][ii]) ? TrueByte : FalseByte;
                            break;
                        case 3:
                            PlayerFourState[ii] = (state[jj][ii]) ? TrueByte : FalseByte;
                            break;
                    }                    
                }
            }
        }

        public void ReadPlayerState(ref Dictionary<int,Dictionary<int,bool>> result)
        {
            for (int jj = 0; jj < PlayerMax; jj++)
            {
                for (int ii = 0; ii < CommandMax; ii++)
                {
                    switch (jj)
                    {
                        case 0:
                            result[jj][ii] = (PlayerOneState[ii] == TrueByte)? true: false;
                            break;
                        case 1:
                            result[jj][ii] = (PlayerTwoState[ii] == TrueByte) ? true : false;
                            break;
                        case 2:
                            result[jj][ii] = (PlayerThreeState[ii] == TrueByte) ? true : false;
                            break;
                        case 3:
                            result[jj][ii] = (PlayerFourState[ii] == TrueByte) ? true : false;
                            break;
                    }
                }
            }          
        }

        public void Clear()
        {
            MessageType = 0;
        }
    }
}
